/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.flooring.ui;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author benth
 */
public interface UserIO {
    void print(String msg);
    
    void print(int msg);

    double readDouble(String prompt);

    double readDouble(String prompt, double min, double max);

    float readFloat(String prompt);

    float readFloat(String prompt, float min, float max);

    int readInt(String prompt);

    int readInt(String prompt, int min, int max);

    long readLong(String prompt);

    long readLong(String prompt, long min, long max);

    String readString(String prompt);
    
    String readStringLong(String prompt);
    
    String readStringLong(String prompt, boolean acceptNull);
    
    String readStringLong(String prompt, List<String> approvedValues);
    
    BigDecimal readBigDecimal(String prompt, boolean isEditing);
    
    LocalDate readLocalDate(String prompt);
    
    
}
