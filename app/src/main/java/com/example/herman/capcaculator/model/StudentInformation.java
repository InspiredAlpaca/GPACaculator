package com.example.herman.capcaculator.model;

/**
 * Created by Herman on 30/7/2017.
 */

public class StudentInformation {
    protected CAP currGPA;
    protected int numOfMods;
    
    public StudentInformation(){
        currGPA = new CAP();
        //Intialize everything to 0 first.
        currGPA.addGPA(0);
        numOfMods = 0;
    }
    
    public void setNumOfMods(int numOfMods){
        this.numOfMods = numOfMods;
    }
    public void setCurrGPA(int currGPA){
        this.currGPA.addGPA(currGPA);
    }
    public void updateNumOfMods(int numOfMods){
        this.numOfMods = numOfMods;
    }
}
