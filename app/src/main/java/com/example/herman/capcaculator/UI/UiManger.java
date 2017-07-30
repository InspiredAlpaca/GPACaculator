package com.example.herman.capcaculator.UI;

import android.app.Activity;
import android.content.Intent;
import com.example.herman.capcaculator.logic.Logic;

/**
 * Created by Herman on 30/7/2017.
 */

public class UiManger {
    private Logic logic;
    
    public UiManger(Logic logic){
        this.logic = logic;
    }
    public void switchActivityToDisplayGPA(Activity activity, int numOfMods){
        Intent intent = new Intent(activity,displayGPA.class);
        intent.putExtra("key","hello");
        activity.startActivity(intent);
    }
}
