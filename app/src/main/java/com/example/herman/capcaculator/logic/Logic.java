package com.example.herman.capcaculator.logic;

import android.app.Activity;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import com.example.herman.capcaculator.R;
import com.example.herman.capcaculator.UI.UiManger;
import com.example.herman.capcaculator.model.Model;

import java.util.logging.Logger;

/**
 * Created by Herman on 29/7/2017.
 */

public class Logic {
    private final Logger logger = Logger.getLogger(Logic.class.getName());
    private final Model modelManager;
    private final UiManger uiManger = new UiManger(this);
    Button submit;
    Editable numOfModsString;
    int numOfMods;
    Activity activity;
    
    public Logic(final Activity activity, final Model modelManager){
        this.activity = activity;
        this.modelManager = modelManager;
        /*
        submit = (Button)activity.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOfModsString = getNumMod();
                numOfMods = Integer.parseInt(numOfModsString.toString().trim());
                modelManager.updateNumOfMods(numOfMods);
                logger.log(Level.INFO,"Num of Mods: " + numOfMods);
                uiManger.switchActivityToDisplayGPA(activity, numOfMods);

            }
        });*/
    }
    
    public Editable getNumMod(){
        EditText numMods = (EditText) activity.findViewById(R.id.numMods);
         return numMods.getText();
    }
}
