package com.example.herman.capcaculator.model;

import java.util.ArrayList;

/**
 * Created by Herman on 1/8/2017.
 */

public class ForecastInformation {
    double[] mods = new double[5];
    int counter;
    
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
    
    public double computeForecastGPA(){
        double totalGPA = 0;
        for(int i = 0; i < counter; i++){
            totalGPA += mods[i];
        }
        return totalGPA;
    }
    public int returnCounter(){
        return counter;
    }
}
