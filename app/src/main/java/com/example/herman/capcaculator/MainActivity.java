package com.example.herman.capcaculator;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.herman.capcaculator.UI.*;
import com.example.herman.capcaculator.logic.Logic;
import com.example.herman.capcaculator.model.Model;
import com.example.herman.capcaculator.model.StudentInformation;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements getInputsListener,FragmentDisplayCAP.displayGPA, inputNewMods.GetSpinnerInputsListener {
    protected Logic logicManager;
    protected Model modelManger;
    FragmentManager fragmentManager;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Located in Resource.Layout folder
        modelManger = initializeModelManger();
        logicManager = new Logic(this, modelManger);
        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.StudentInputInfo, new FragmentInputsDisplay(), "inputDisplay");
        fragmentTransaction.add(R.id.inputNewMods, new inputNewMods());
        fragmentTransaction.commit();
    }
    
    public Model initializeModelManger() {
        StudentInformation initialData;
        initialData = new StudentInformation();
        return new Model(initialData);
    }
    
    @Override
    public void getInput(String currGPA, String numOfMods, String numOfSUs) {
        modelManger.updateNumOfMods(Integer.parseInt(numOfMods));
        modelManger.updateCurrGPA(Double.parseDouble(currGPA));
        modelManger.updateNumOfSUs(Integer.parseInt(numOfSUs));
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.StudentInputInfo, new FragmentDisplayCAP());
        fragmentTransaction.addToBackStack(null); //By calling addToBackStack(), the replace transaction is saved
        // to the back stack so the user can reverse the transaction and bring back the previous fragment by pressing the Back button
        fragmentTransaction.commit();
    }
    
    @Override
    public void getSpinnerListener(String mod1,String mod2,String mod3,String mod4,String mod5) {
        modelManger.setNewMods(mod1,mod2,mod3,mod4,mod5);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.StudentInputInfo, new FragmentDisplayCAP());
        fragmentTransaction.addToBackStack(null); //By calling addToBackStack(), the replace transaction is saved
        // to the back stack so the user can reverse the transaction and bring back the previous fragment by pressing the Back button
        fragmentTransaction.commit();
    }
    @Override
    public double updateCAP() {
        double computedCAP = logicManager.computeCombinedForecast();
        return computedCAP;
    }
}


