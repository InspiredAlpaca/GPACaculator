package com.example.herman.capcaculator.model;

/**
 * Created by Herman on 29/7/2017.
 */

public class Model {
    protected StudentInformation currentProgramInstance;
    
    public Model(StudentInformation studentInformation){
        this.currentProgramInstance = studentInformation;
    }
    
    public void updateNumOfMods(int numOfMods){
        currentProgramInstance.updateNumOfMods(numOfMods);
    }
}
