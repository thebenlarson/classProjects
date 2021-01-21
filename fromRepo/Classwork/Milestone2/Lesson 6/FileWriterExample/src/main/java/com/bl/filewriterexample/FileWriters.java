/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.filewriterexample;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author benth
 */
public class FileWriters {
    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
        out.println("this is a line in my file...");
        out.println("a second line in my file...");
        out.println("a third line in my file...");
        out.flush();
        out.close();
    }
}
