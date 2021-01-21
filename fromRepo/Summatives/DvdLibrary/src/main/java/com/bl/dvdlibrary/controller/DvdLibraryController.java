/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.dvdlibrary.controller;

import com.bl.dvdlibrary.dao.*;
import com.bl.dvdlibrary.dto.*;
import com.bl.dvdlibrary.ui.*;
import java.util.List;

/**
 *
 * @author benth
 */
public class DvdLibraryController {
    DvdLibraryView view;
    DvdLibraryDao dao;
    
    public DvdLibraryController(DvdLibraryView view, DvdLibraryDao dao){
        this.view = view;
        this.dao = dao;
    }
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        loadData();
        
        while (keepGoing) {
            
            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    listDvds();
                    break;
                case 2:
                    viewDvd();
                    break;
                case 3:
                    addDvd();
                    break;
                case 4:
                    editDvd();
                    break;
                case 5:
                    removeDvd();
                    break;
                case 6:
                    searchDvds();
                    break;
                case 7:
                    keepGoing = false;
                    break;
                case 8:
                    getDvdsByYear();
                    break;
                case 9:
                    getDvdsByMPAA();
                    break;
                case 10:
                    getDvdsByDirector();
                    break;
                case 11:
                    getDvdsByStudio();
                    break;
                case 12:
                    getAvgYear();
                    break;
                case 13:
                    getNewest();
                    break;
                case 14:
                    getOldest();
                    break;
                default:
                    unknownCommand();
            }

        }
        saveData();
        exitMessage();
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void addDvd() {
        view.displayAddDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getId(), newDvd);
        view.displayAddSuccessBanner();
    }
    
    private void listDvds() {
        view.displayDisplayAllBanner();
        List<Dvd> collection = dao.getAllDvds();
        view.displayDvdList(collection);
    }
    
    private void viewDvd(){
        view.displayDisplayDvdBanner();
        String id = view.getDvdIdChoice();
        Dvd dvd = dao.getDvd(id);
        view.displayDvd(dvd);
    }
    
    private void removeDvd(){
        view.displayRemoveDvdBanner();
        String id = view.getDvdIdChoice();
        dao.removeDvd(id);
        view.displayRemoveSuccessBanner();
    }
    
    private void searchDvds(){
        view.displaySearchBanner();
        String title = view.getDvdTitleChoice();
        List<Dvd> dvds = dao.searchDvd(title);
        view.displayDvdList(dvds);
    }
    
    private void editDvd(){
        view.displayEditDvdBanner();
        String id = view.getDvdIdChoice();
        Dvd dvd = dao.getDvd(id);
        dvd = view.getEditDvdInfo(dvd);
        dao.addDvd(id, dvd);
        view.displayEditSuccessBanner();
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
    
    private void loadData(){
        try {
            //loads the dvds from file
            dao.loadCollection();
        } catch (DvdLibraryDaoException ex) {
            view.displayLoadingError(ex);
        }
    }
    
    private void saveData(){
        try {
            //saves dvds to file
            dao.writeCollection();
        } catch (DvdLibraryDaoException ex) {
            view.displayLoadingError(ex);
        }
    }
    
    private void getDvdsByYear(){
        view.displaySearchByYearBanner();
        int x = view.getSearchByYear();
        view.displayDvdList(dao.getMoviesByYear(x));
    }
    
    private void getDvdsByMPAA(){
        view.displaySearchByMPAABanner();
        String x = view.getSearchByMPAA();
        view.displayDvdList(dao.getMoviesByMPAA(x));
    }
    
    private void getDvdsByDirector(){
        view.displaySearchByDirectorBanner();
        String x = view.getSearchByDirector();
        view.displayDvdMap(dao.getMoviesByDirector(x));
    }
    
    private void getDvdsByStudio(){
        view.displaySearchByStudioBanner();
        String x = view.getSearchByStudio();
        view.displayDvdList(dao.getMoviesByStudio(x));
    }
    
    private void getAvgYear(){
        view.displayAvgYearBanner();
        view.displayAvgYear(dao.getAverageYear());
    }
    
    private void getNewest(){
        view.displayNewestBanner();
        view.displayDvdOne(dao.newestDvd());
    }
    
    private void getOldest(){
        view.displayOldestBanner();
        view.displayDvdOne(dao.oldestDvd());
    }
    
}
