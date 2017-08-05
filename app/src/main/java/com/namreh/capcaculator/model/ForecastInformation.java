package com.namreh.capcaculator.model;

import java.util.ArrayList;

public class ForecastInformation {
    double[] mods = new double[5];
    int[] gradeCredit = new int[5];
    int counter;
    
    /**
     * This method receives the grade in the spinner and update it into an array.
     * @param mod1 Each grade represents a number except null
     * @param mod2
     * @param mod3
     * @param mod4
     * @param mod5
     */
    public void setMods(String mod1,String mod2,String mod3,String mod4,String mod5){
        counter = 0;
        ArrayList<String> stringArray = new ArrayList<String>();
        stringArray.add(mod1);
        stringArray.add(mod2);
        stringArray.add(mod3);
        stringArray.add(mod4);
        stringArray.add(mod5);
        for(int i = 0; i < 5; i++){
            String mod = stringArray.get(i);
            switch(mod){
                case "null": break;
                case "A+": counter++;
                    mods[i] = 5.0;
                    break;
                case "A": counter++;
                    mods[i] = 5.0;
                    break;
                case "A-": counter++;
                    mods[i] = 4.5;
                    break;
                case "B+": counter++;
                    mods[i] = 4.0;
                    break;
                case "B": counter++;
                    mods[i] = 3.5;
                    break;
                case "B-": counter++;
                    mods[i] = 3.0;
                    break;
                case "C+": counter++;
                    mods[i] = 2.5;
                    break;
                case "C": counter++;
                    mods[i] = 2.0;
                    break;
                case "D+": counter++;
                    mods[i] = 1.5;
                    break;
                case "D": counter++;
                    mods[i] = 1.0;
                    break;
                
                    
            }
        }
    }
    
    public void setGradeCredits(String mod1,String mod2,String mod3,String mod4,String mod5) {
        ArrayList<String> stringArray = new ArrayList<String>();
        stringArray.add(mod1);
        stringArray.add(mod2);
        stringArray.add(mod3);
        stringArray.add(mod4);
        stringArray.add(mod5);
        for(int i = 0; i < counter; i++){
            gradeCredit[i] = Integer.parseInt(stringArray.get(i));
        }
    }
    
    /**
     * This method sums up the raw total point for the new semester for futher gradePoint computation
     * @return Sum of current semester total point
     */
    public double getRawTotalPoints(){
        double totalGPA = 0;
        for(int i = 0; i < counter; i++){
            totalGPA += (mods[i]* gradeCredit[i]);
        }
        return totalGPA;
    }
    
    /**
     * This method returns the number of mods in forecasting
     * @return
     */
    public int getNumOfModInNewSem(){
        int totalCredits = 0;
        for(int i = 0; i < counter; i++){
            totalCredits += gradeCredit[i];
        }
        return totalCredits;
    }
}
