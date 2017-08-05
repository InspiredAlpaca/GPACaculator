package com.namreh.capcaculator.logic;

import android.app.Activity;
import com.namreh.capcaculator.model.Model;

import java.util.logging.Logger;

public class Logic {
    private final Logger logger = Logger.getLogger(Logic.class.getName());
    private final Model modelManager;
    Activity activity;
    
    public Logic(final Activity activity, final Model modelManager){
        this.activity = activity;
        this.modelManager = modelManager;
    }
    
    /**
     *
     * @return
     */
    public double computeCombinedForecast(){
        int creditsEarned;
        if(modelManager.getNumOfMods() != 0){
            int validMods = modelManager.getNumOfMods() - modelManager.getNumOfSU();
            creditsEarned = validMods * 4;
        } else {
            creditsEarned = modelManager.getCreditsEarned();
        }
        int forecastModsCredit = modelManager.getForecastMods();
        double initialGradePoints = creditsEarned * modelManager.getCurrGPA();
        double forecastGradePoints = modelManager.getTotalGPA();
        double finalGradePoints =  initialGradePoints + forecastGradePoints;
        int finalModsCredit = forecastModsCredit + creditsEarned;
        double finalCAP = finalGradePoints/finalModsCredit;

        
        int currNumOfMods = modelManager.getNumOfMods() - modelManager.getNumOfSU();
        double currOverallGPA = modelManager.getCurrGPA()* currNumOfMods;
        int totalForecastMods = currNumOfMods + modelManager.getForecastMods();
        double overallGPA = currOverallGPA + modelManager.getTotalGPA();
        return finalCAP;
    }
}
