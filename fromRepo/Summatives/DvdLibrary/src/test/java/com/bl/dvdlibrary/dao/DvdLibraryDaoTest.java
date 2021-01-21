/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.dvdlibrary.dao;

import com.bl.dvdlibrary.dto.Dvd;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author benth
 */
public class DvdLibraryDaoTest {
    
    DvdLibraryDao dao = new DvdLibraryFileImpl();
    
    public DvdLibraryDaoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        List<Dvd> dvdList = dao.getAllDvds();
        for (Dvd dvd : dvdList){
            dao.removeDvd(dvd.getId());
        }
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addDvd method, of class DvdLibraryDao.
     */
    @Test
    public void testAddGetDvd() {
        //need to add it
        Dvd dvd = new Dvd("001");
        dvd.setTitle("BB");
        dvd.setReleaseDate("1999-01-01");
        dvd.setMpaaRating("B");
        dvd.setDirector("BB");
        dvd.setStudio("BB34534t");
        dvd.setUserRatingNotes("123456789");
        
        dao.addDvd(dvd.getId(), dvd);
        
        //then get it to see if it saved
        Dvd other = dao.getDvd(dvd.getId());
        assertEquals(dvd, other);
    }

    /**
     * Test of getAllDvds method, of class DvdLibraryDao.
     */
    @Test
    public void testGetAllDvds() {
        //assertEquals(0, dao.getAllDvds().size());
        Dvd dvd = new Dvd("001");
        dvd.setTitle("BB");
        dvd.setReleaseDate("1999-01-01");
        dvd.setMpaaRating("B");
        dvd.setDirector("BB");
        dvd.setStudio("BB34534t");
        dvd.setUserRatingNotes("123456789");
        
        dao.addDvd(dvd.getId(), dvd);
        
        Dvd dvd2 = new Dvd("002");
        dvd2.setTitle("BB");
        dvd2.setReleaseDate("1999-01-01");
        dvd2.setMpaaRating("B");
        dvd2.setDirector("BB");
        dvd2.setStudio("BB34534t");
        dvd2.setUserRatingNotes("123456789");
        
        dao.addDvd(dvd2.getId(), dvd2);
        
        assertEquals(2, dao.getAllDvds().size());
    }

    /**
     * Test of getDvd method, of class DvdLibraryDao.
     */
    @Test
    public void testGetDvd() {
        //completed in the addGet method
    }

    /**
     * Test of removeDvd method, of class DvdLibraryDao.
     */
    @Test
    public void testRemoveDvd() {
        assertEquals(0, dao.getAllDvds().size());
        Dvd dvd = new Dvd("001");
        dvd.setTitle("BB");
        dvd.setReleaseDate("1999-01-01");
        dvd.setMpaaRating("B");
        dvd.setDirector("BB");
        dvd.setStudio("BB34534t");
        dvd.setUserRatingNotes("123456789");
        
        dao.addDvd(dvd.getId(), dvd);
        
        Dvd dvd2 = new Dvd("002");
        dvd2.setTitle("BB");
        dvd2.setReleaseDate("1999-01-01");
        dvd2.setMpaaRating("B");
        dvd2.setDirector("BB");
        dvd2.setStudio("BB34534t");
        dvd2.setUserRatingNotes("123456789");
        
        dao.addDvd(dvd2.getId(), dvd2);
        
        dao.removeDvd(dvd.getId());
        assertEquals(1, dao.getAllDvds().size());
        assertNull(dao.getDvd(dvd.getId()));
        
        dao.removeDvd(dvd2.getId());
        assertEquals(0, dao.getAllDvds().size());
        assertNull(dao.getDvd(dvd2.getId()));
    }

    /**
     * Test of searchDvd method, of class DvdLibraryDao.
     */
    @Test
    public void testSearchDvd() {
        Dvd dvd = new Dvd("001");
        dvd.setTitle("BB");
        dvd.setReleaseDate("1999-01-01");
        dvd.setMpaaRating("B");
        dvd.setDirector("BB");
        dvd.setStudio("BB34534t");
        dvd.setUserRatingNotes("123456789");
        
        dao.addDvd(dvd.getId(), dvd);
        
        Dvd dvd2 = new Dvd("002");
        dvd2.setTitle("BB");
        dvd2.setReleaseDate("1999-01-01");
        dvd2.setMpaaRating("B");
        dvd2.setDirector("BB");
        dvd2.setStudio("BB34534t");
        dvd2.setUserRatingNotes("123456789");
        
        dao.addDvd(dvd2.getId(), dvd2);
        
        /*
        Dvd dvd3 = new Dvd("003");
        dvd3.setTitle("BwrgergB");
        dvd3.setReleaseDate("1999");
        dvd3.setMpaaRating("B");
        dvd3.setDirector("BB");
        dvd3.setStudio("BB34534t");
        dvd3.setUserRatingNotes("123456789");
        
        dao.addDvd(dvd3.getId(), dvd3);
        assertEquals(1, dao.searchDvd(dvd3.getTitle()).size());
        */
        
        assertEquals(2, dao.searchDvd(dvd.getTitle()).size());
        assertEquals(0, dao.searchDvd("QEGAETGHEHGEHEGAEGETHAETH").size());
    }
    
    @Test
    public void testLoadCollection() {
        //completed in the addGet method
    }
    
    @Test
    public void testWriteCollection() {
        //completed in the addGet method
    }
    
}
