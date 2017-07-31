package com.example.herman.capcaculator.model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Herman on 30/7/2017.
 */

public class StudentInformation {
    private final Logger logger = Logger.getLogger(StudentInformation.class.getName());
    protected double currGPA;
    protected int numOfMods;
    private int numOfSUs;
    
    public StudentInformation(){

        //Intialize everything to 0 first.
        numOfMods = 0;
        currGPA = 0;
        numOfSUs = 0;
    }
    
    public void setNumOfMods(int numOfMods){
        this.numOfMods = numOfMods;
    }
    public void setCurrGPA(int currGPA){ this.currGPA = currGPA; }
    public void updateNumOfMods(int numOfMods){
        this.numOfMods = numOfMods;
        logger.log(Level.INFO, "Current num of mods in Model is: " + numOfMods);
    }
    public void updateCurrGPA(double CurrGPA){
        this.currGPA = CurrGPA;
        logger.log(Level.INFO, "Current GPA in Model is: " + currGPA);
    }
    public void updateNumOfSUs(int numOfSUs){
        this.numOfSUs = numOfSUs;
        logger.log(Level.INFO, "Current num of SUs in Model is: " + numOfSUs);
    }
    public int getNumOfMods(){
        return numOfMods;
    }
    public double getCurrGPA(){
        return currGPA;
    }
    public int getNumOfSUs(){
        return numOfSUs;
    }
}
