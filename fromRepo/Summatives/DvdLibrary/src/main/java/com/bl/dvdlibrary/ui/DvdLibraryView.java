/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.dvdlibrary.ui;

import com.bl.dvdlibrary.dao.DvdLibraryDaoException;
import com.bl.dvdlibrary.dto.Dvd;
import java.util.List;
import java.util.Map;

/**
 *
 * @author benth
 */
public class DvdLibraryView {
    UserIO io;
    
    public DvdLibraryView(UserIO io){
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
            io.print("1. List DVDs");
            io.print("2. View specific DVD");
            io.print("3. Add DVD");
            io.print("4. Edit DVD");
            io.print("5. Remove DVD");
            io.print("6. Search DVDs by Title");
            io.print("7. Exit");
            io.print("8. Search DVDs by Year");
            io.print("9. Search DVDs by MPAA");
            io.print("10. Search DVDs by Director");
            io.print("11. Search DVDs by Studio");
            io.print("12. Get Average Year");
            io.print("13. Get Newest DVD");
            io.print("14. Get Oldest DVD");

        return io.readInt("Please select from the above choices.", 1, 20);
    }
    
    public Dvd getNewDvdInfo() {
        //gets new dvd info and returns a new dvd
        String id = io.readStringLong("Please enter DVD ID");
        Dvd currentDvd = new Dvd(id);
        
        currentDvd = getEditDvdInfo(currentDvd);
        

        return currentDvd;
    }
    
    public Dvd getEditDvdInfo(Dvd myDvd){
        String title = io.readStringLong("Please enter Title: (Current Value) " + myDvd.getTitle());
        String releaseDate = io.readStringLong("Please enter Release Date (year only): (Current Value) " + myDvd.getReleaseDate());
        String mpaaRating = io.readStringLong("Please enter MPAA Rating: (Current Value) " + myDvd.getMpaaRating());
        String director = io.readStringLong("Please enter Director's Name: (Current Value) " + myDvd.getDirector());
        String studio = io.readStringLong("Please enter Studio: (Current Value) " + myDvd.getStudio() );
        String userRatingNotes = io.readStringLong("Please enter User Rating / Notes: (Current Value) " + myDvd.getUserRatingNotes());
        
        if (!title.equals("")){
            myDvd.setTitle(title);
        }
        if (!releaseDate.equals("")){
            myDvd.setReleaseDate(releaseDate);
        }
        if (!mpaaRating.equals("")){
            myDvd.setMpaaRating(mpaaRating);
        }
        if (!director.equals("")){
            myDvd.setDirector(director);
        }
        if (!studio.equals("")){
            myDvd.setStudio(studio);
        }
        if (!userRatingNotes.equals("")){
            myDvd.setUserRatingNotes(userRatingNotes);
        }
        
        return myDvd;
    }
    
    public void displayAddDvdBanner() {
        io.print("=== Add DVD ===");
    }
    
    public void displayAddSuccessBanner() {
        io.readStringLong(
                "Add successfully created.  Please hit enter to continue");
    }
    
    public void displayEditDvdBanner() {
        io.print("=== Edit DVD ===");
        io.print("To keep the same value just press Enter");
    }
    
    public void displayEditSuccessBanner() {
        io.readStringLong(
                "Edit successfully saved.  Please hit enter to continue");
    }
    
    public void displayDvdOne(Dvd dvd){
        io.print(dvd.getId() + ": "
                    + dvd.getTitle() + " "
                    + dvd.getReleaseDate()+ " "
                    + dvd.getMpaaRating() + " "
                    + dvd.getDirector() + " "
                    + dvd.getStudio() + " "
                    + dvd.getUserRatingNotes());
    }
    
    public void displayDvdList(List<Dvd> collection) {
        for (Dvd currentDvd : collection) {
            displayDvdOne(currentDvd);
        }
        io.readStringLong("Please hit enter to continue.");
    }
    
    public void displayDvdMap(Map<String, List<Dvd>> map){
        map.forEach(( k, v) -> {
            io.print("Dvds of Rating: " + k);
            v.forEach((dvd) -> displayDvdOne(dvd));
        });
        io.readStringLong("Please hit enter to continue.");
    }
    
    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }
    
    public void displayDisplayDvdBanner () {
        io.print("=== Display DVD ===");
    }

    public String getDvdIdChoice() {
        return io.readString("Please enter the DVD ID.");
    }

    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            io.print(dvd.getId());
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getDirector());
            io.print(dvd.getStudio());
            io.print(dvd.getUserRatingNotes());
            io.print("");
        } else {
            io.print("No such DVD.");
        }
        io.readStringLong("Please hit enter to continue.");
    }
    
    public void displayRemoveDvdBanner () {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveSuccessBanner () {
        io.readStringLong("DVD successfully removed. Please hit enter to continue.");
    }
    
    public void displaySearchBanner () {
        io.print("=== DVD Search ===");
    }
    
    public String getDvdTitleChoice() {
        return io.readStringLong("Please enter the DVD Title.");
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    public void displayLoadingError (DvdLibraryDaoException ex) {
        io.print(ex);
        io.print("Error loading DVDs. Please try again.");
    }
    
    public void displaySearchByYearBanner () {
        io.print("=== DVD Search By Year ===");
    }
    
    public int getSearchByYear () {
        return io.readInt("Please enter the years for how recent the videos need to be.");
    }
    
    public void displaySearchByMPAABanner () {
        io.print("=== DVD Search By MPAA ===");
    }
    
    public String getSearchByMPAA () {
        return io.readStringLong("Please enter the MPAA rating.");
    }
    
    public void displaySearchByDirectorBanner () {
        io.print("=== DVD Search By Director ===");
    }
    
    public String getSearchByDirector () {
        return io.readStringLong("Please enter the Director.");
    }
    
    public void displaySearchByStudioBanner () {
        io.print("=== DVD Search By Studio ===");
    }
    
    public String getSearchByStudio () {
        return io.readStringLong("Please enter the Studio.");
    }
    public void displayAvgYearBanner () {
        io.print("=== Average Year of DVD's ===");
    }
    
    public void displayAvgYear (double avg) {
        io.print("Average: " + avg);
    }
    
    public void displayNewestBanner () {
        io.print("=== Newest DVD's ===");
    }
    
    public void displayOldestBanner () {
        io.print("=== Oldest DVD's ===");
    }
    
    public void displayNewest (Dvd dvd) {
        displayDvdOne(dvd);
    }
    
    
}
