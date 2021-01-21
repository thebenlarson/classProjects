/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.dvdlibrary.dao;

import com.bl.dvdlibrary.dto.*;
import java.util.List;
import java.util.Map;

/**
 *
 * @author benth
 */
public interface DvdLibraryDao {
    
    // Adds dvd to collection. Returns Dvd if one already exists at that id
    Dvd addDvd(String id, Dvd dvd);
    
    //Returns list of all dvds
    List<Dvd> getAllDvds();
    
    //returns the specific Dvd asked for, or null if not found
    Dvd getDvd(String id);
    
    //removes the dvd. Returns the dvd being removed
    Dvd removeDvd(String id);
    
    List<Dvd> searchDvd(String title);
    
    void loadCollection() throws DvdLibraryDaoException;
    
    void writeCollection () throws DvdLibraryDaoException;
    
    List<Dvd> getMoviesByYear(int years);
    
    List<Dvd> getMoviesByMPAA(String rating);
    
    Map<String, List<Dvd>> getMoviesByDirector(String name);
    
    List<Dvd> getMoviesByStudio(String rating);
    
    double getAverageYear();
    
    Dvd newestDvd();
    
    Dvd oldestDvd();
}
