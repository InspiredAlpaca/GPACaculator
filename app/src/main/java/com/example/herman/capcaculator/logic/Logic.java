package com.example.herman.capcaculator.logic;

import android.app.Activity;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import com.example.herman.capcaculator.R;
import com.example.herman.capcaculator.model.Model;

import java.util.logging.Logger;

/**
 * Created by Herman on 29/7/2017.
 */

public class Logic {
    private final Logger logger = Logger.getLogger(Logic.class.getName());
    private final Model modelManager;
    Activity activity;
    
    public Logic(final Activity activity, final Model modelManager){
        this.activity = activity;
        this.modelManager = modelManager;
    }
    public double computeCombinedForecast(){
        int currNumOfMods = modelManager.getNumOfMods() - modelManager.getNumOfSU();
        double currOverallGPA = modelManager.getCurrGPA()* currNumOfMods;
        int totalForecastMods = currNumOfMods + modelManager.getForecastMods();
        double overallGPA = currOverallGPA + modelManager.getTotalGPA();
        return overallGPA/totalForecastMods;
    }
}
