/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.dvdlibrary.dao;

import com.bl.dvdlibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author benth
 */
public class DvdLibraryFileImpl implements DvdLibraryDao {
    private Map<String, Dvd> collection = new HashMap<>();
    public static final String SAVE_FILE = "collection.txt";
    public static final String DELIMITER = "::";

    @Override
    public Dvd addDvd(String id, Dvd dvd) {
        //double for both adding and editing
        Dvd newDvd = collection.put(id, dvd);
        return newDvd;
    }

    @Override
    public List<Dvd> getAllDvds() {
        return new ArrayList<Dvd>(collection.values());
    }

    @Override
    public Dvd getDvd(String id) {
        return collection.get(id);
    }

    @Override
    public Dvd removeDvd(String id) {
        Dvd dvd = collection.remove(id);
        return dvd;
    }
    
    @Override
    public List<Dvd> searchDvd(String title){
        ArrayList<Dvd> dvds = new ArrayList<>();
        for (Dvd dvd : collection.values()){
            if (dvd.getTitle().equals(title)){
                dvds.add(dvd);
            }
        }
        return dvds;
    }
    
    private Dvd unmarshallDvd(String dvdAsString){
        String[] dvdTokens = dvdAsString.split(DELIMITER);
        String id = dvdTokens[0];
        Dvd dvdFromFile = new Dvd(id);
        dvdFromFile.setTitle(dvdTokens[1]);
        dvdFromFile.setReleaseDate(dvdTokens[2]);
        dvdFromFile.setMpaaRating(dvdTokens[3]);
        dvdFromFile.setDirector(dvdTokens[4]);
        dvdFromFile.setStudio(dvdTokens[5]);
        dvdFromFile.setUserRatingNotes(dvdTokens[6]);
        
        return dvdFromFile;
    }
    
    @Override
    public void loadCollection() throws DvdLibraryDaoException{
        Scanner scanner;
        
        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(SAVE_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException(
                    "-_- Could not load collection data into memory.", e);
        }
        
        String currentLine;
        Dvd currentDvd;
        
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Student
            currentDvd = unmarshallDvd(currentLine);

            // We are going to use the student id as the map key for our student object.
            // Put currentStudent into the map using student id as the key
            collection.put(currentDvd.getId(), currentDvd);
        }
        // close scanner
        scanner.close();
    }
    
    private String marshallDvd (Dvd dvd){
        String dvdAsString = dvd.getId() + DELIMITER;
        dvdAsString += dvd.getTitle() + DELIMITER;
        dvdAsString += dvd.getReleaseDate()+ DELIMITER;
        dvdAsString += dvd.getMpaaRating()+ DELIMITER;
        dvdAsString += dvd.getDirector()+ DELIMITER;
        dvdAsString += dvd.getStudio()+ DELIMITER;
        dvdAsString += dvd.getUserRatingNotes();
        
        return dvdAsString;
    }
    
    @Override
    public void writeCollection () throws DvdLibraryDaoException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(SAVE_FILE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException(
                    "Could not save student data.", e);
        }
        
        String dvdAsString;
        List<Dvd> dvdList = this.getAllDvds();
        
        for (Dvd currentDvd : dvdList) {
            // turn a Student into a String
            dvdAsString = marshallDvd(currentDvd);
            // write the Student object to the file
            out.println(dvdAsString);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
    
    @Override
    public List<Dvd> getMoviesByYear(int years){
        return collection.values()
                .stream()
                .filter(d -> 2020 - d.getYear() <= years)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Dvd> getMoviesByMPAA(String rating){
        return collection.values()
                .stream()
                .filter(d -> d.getMpaaRating().equalsIgnoreCase(rating))
                .collect(Collectors.toList());
    }
    
    @Override
    public Map<String, List<Dvd>> getMoviesByDirector(String name){
        return collection.values()
                .stream()
                .filter(d -> d.getDirector().equalsIgnoreCase(name))
                .collect(Collectors.groupingBy(Dvd::getMpaaRating));
    }
    
    @Override
    public List<Dvd> getMoviesByStudio(String rating){
        return collection.values()
                .stream()
                .filter(d -> d.getStudio().equalsIgnoreCase(rating))
                .collect(Collectors.toList());
    }
    
    @Override
    public double getAverageYear(){
        return 2020 - collection.values()
                .stream()
                .mapToDouble(dvd -> dvd.getYear())
                .average()
                .getAsDouble();
    }
    
    @Override
    public Dvd newestDvd(){
        List<Dvd> myList  = collection.values()
                .stream()
                .sorted(Comparator.comparingLong(Dvd::getYearEpoch))
                .collect(Collectors.toList());
        
        return myList.get(myList.size() - 1);
    }
    
    @Override
    public Dvd oldestDvd(){
        return collection.values()
                .stream()
                .sorted(Comparator.comparingLong(Dvd::getYearEpoch))
                .collect(Collectors.toList())
                .get(0);
    }
}
