/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.studentquizgrades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author benth
 */
public class StudentGrades {
    IOClass iO = new IOClass();
    HashMap<String, ArrayList<Integer>> grades = new HashMap<>();
    Set<String> names;
    ArrayList<Integer> studentGrades;
    
    int total, count;
    
    //need an add grade to student, add student
    
    public void updateNames(){
        names = grades.keySet();
    }
    
    public void addGrade(String name, int grade){
        updateNames();
        if (names.contains(name)){
            // get the grades ArrayList
            studentGrades = grades.get(name);
        } else {
            //need to make a new record of grades
            studentGrades = new ArrayList<>();
        }
        studentGrades.add(grade);
        grades.put(name, studentGrades);
    }
    
    public void addGradeWithPrompt(){
        String name = iO.readString("Enter the students name");
        int grade = iO.readInt("Enter grade: ");
        addGrade(name, grade);
    }
    
    public void addStudent(String name){
        updateNames();
        if (!names.contains(name)){
            studentGrades = new ArrayList<>();
            grades.put(name, studentGrades);
        }
    }
    
    public void addWithPrompt(){
        String name = iO.readString("Enter the students name");
        addStudent(name);
    }
    
    public Set<String> getStudents(){
        updateNames();
        return names;
    }
    
    public void printStudents(){
        updateNames();
        for (String name : names){
            iO.print(name);
        }
    }
    
    public void removeStudent(String name){
        if (names.contains(name)){
            grades.remove(name);
        }
    }
    
    public void removeWithPrompt(){
        String name = iO.readString("Enter the students name");
        removeStudent(name);
    }
    
    public ArrayList<Integer> getScores(String name){
        studentGrades = null;
        if (names.contains(name)){
            studentGrades = grades.get(name);
        }
        
        return studentGrades;
    }
    
    public void printScores(){
        String name = iO.readString("Enter the students name");
        studentGrades = getScores(name);
        
        for (int grade : studentGrades){
            iO.print(grade);
        }
    }
    
    public void printAverage(){
        String name = iO.readString("Enter the students name");
        iO.print(getAverage(name));
        
    }
    
    public double getAverage(String name){
        studentGrades = getScores(name);
        int total = 0, count = 0;
        for (Integer score : studentGrades){
            total += score;
            count++;
        }
        
        return ((double) total / (double) count);
    }
    
    public void getClassAverage(){
        updateNames();
        initClassAvg();
        names.forEach((student) -> {
            grades.get(student).forEach((grade) -> {
                calculate(grade);
            });
        });
        
        double avg = (double) total / (double) count;
        System.out.println("Class Average: " + avg);
    }
    
    public void calculate(double grade){
        total += grade;
        count++;
    }
    
    public void initClassAvg(){
        total = 0;
        count = 0;
    }
    
    public void processChoice(int choice){
        switch(choice){
            case 0: 
                //Add a grade to student
                addGradeWithPrompt();
                break;
            case 1: 
                //View Students
                printStudents();
                break;
            case 2: 
                //Add Student
                addWithPrompt();
                break;
            case 3: 
                //Remove Students
                removeWithPrompt();
                break;
            case 4: 
                //View Student's Scores
                printScores();
                break;
            case 5: 
                //View Student's Average
                printAverage();
                break;
            case 6:
                //Print Class Average
                getClassAverage();
                break;
            default:
                System.exit(0);
        
        
        
        }
    }
}
