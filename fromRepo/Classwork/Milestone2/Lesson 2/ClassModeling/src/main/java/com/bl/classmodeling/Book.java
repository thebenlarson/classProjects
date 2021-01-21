/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.classmodeling;

/**
 *
 * @author benth
 */
public class Book {
    private String title;
    private int numberOfWords;
    private int libraryId;
    private boolean inStock;

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public Book(String title) {
        this.title = title;
    }

    public Book(String title, int libraryId) {
        this.title = title;
        this.libraryId = libraryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfWords() {
        return numberOfWords;
    }

    public void setNumberOfWords(int numberOfWords) {
        this.numberOfWords = numberOfWords;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }
    
    public void checkStatus(){
        if (this.inStock){
            System.out.println("The book is in stock!");
        } else {
            System.out.println("The book is out of stock!");
        }
        
    }
}
