package com.example.herman.capcaculator.model;

/**
 * Created by Herman on 29/7/2017.
 */

public class Model {
    protected StudentInformation currentProgramInstance;
    protected ForecastInformation forecastInformation = new ForecastInformation();
    
    public Model(StudentInformation studentInformation){
        this.currentProgramInstance = studentInformation;
    }
    
    public void updateNumOfMods(int numOfMods){
        currentProgramInstance.updateNumOfMods(numOfMods);
    }
    public void updateCurrGPA(double currGPA){
        currentProgramInstance.updateCurrGPA(currGPA);
    }
    public void updateNumOfSUs(int NumOfSUs){
        currentProgramInstance.updateNumOfSUs(NumOfSUs);
    }
    
    public int getNumOfMods(){
        return currentProgramInstance.getNumOfMods();
    }
    public double getCurrGPA(){
        return currentProgramInstance.getCurrGPA();
    }
    public int getNumOfSU(){
        return currentProgramInstance.getNumOfSUs();
    }
    
    public void setNewMods(String mod1,String mod2,String mod3,String mod4,String mod5){
       forecastInformation.setMods(mod1,mod2,mod3,mod4,mod5);
}
    
    public int getForecastMods(){
        return forecastInformation.returnCounter();
    }
    public double getTotalGPA(){
        return forecastInformation.computeForecastGPA();
    }
        
    
}
