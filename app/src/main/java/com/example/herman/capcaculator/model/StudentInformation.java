package com.example.herman.capcaculator.model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class holds the data for the student
 */
public class StudentInformation {
    private final Logger logger = Logger.getLogger(StudentInformation.class.getName());
    protected double currGPA;
    protected int numOfMods;
    private int numOfSUs;
    private int creditsEarned;
    //Constructor
    public StudentInformation(){
        //Intialize everything to 0 first.
        numOfMods = 0;
        currGPA = 0;
        numOfSUs = 0;
        creditsEarned = 0;
    }
    
    /**
     * This method updates the total current credits the student has.
     * @param creditsEarned
     */
    public void updateCreditsEarned(int creditsEarned){
        this.creditsEarned = creditsEarned;
    }
    
    /**
     * This method updates the current student's CAP
     * @param CurrGPA
     */
    public void updateCurrGPA(double CurrGPA){
        this.currGPA = CurrGPA;
        logger.log(Level.INFO, "Current GPA in Model is: " + currGPA);
    }
    
    /**
     * This method gets the student's current credits earned
     * @return
     */
    public int getCreditsEarned(){
        return creditsEarned;
    }
    
    /**
     * This method returns the student's current CAP
     * @return
     */
    public double getCurrGPA(){
        return currGPA;
    }
    
    
    
    public void updateNumOfMods(int numOfMods){
        this.numOfMods = numOfMods;
        logger.log(Level.INFO, "Current num of mods in Model is: " + numOfMods);
    }
    public void updateNumOfSUs(int numOfSUs){
        this.numOfSUs = numOfSUs;
        logger.log(Level.INFO, "Current num of SUs in Model is: " + numOfSUs);
    }

    public int getNumOfMods(){
        return numOfMods;
    }
    public int getNumOfSUs(){
        return numOfSUs;
    }
}
