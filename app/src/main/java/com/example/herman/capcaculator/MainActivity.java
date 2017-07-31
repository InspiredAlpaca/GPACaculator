package com.example.herman.capcaculator;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.herman.capcaculator.UI.FragmmentDisplayCAP;
import com.example.herman.capcaculator.UI.FragmmentInputsDisplay;
import com.example.herman.capcaculator.UI.getInputsListener;
import com.example.herman.capcaculator.UI.UiManger;
import com.example.herman.capcaculator.logic.Logic;
import com.example.herman.capcaculator.model.Model;
import com.example.herman.capcaculator.model.StudentInformation;


public class MainActivity extends AppCompatActivity implements getInputsListener {
    protected Logic logicManager;
    protected Model modelManger;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Located in Resource.Layout folder
        modelManger = initializeModelManger();
        logicManager = new Logic(this,modelManger);
        UiManger uiManger = new UiManger(logicManager);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentParentViewGroup, new FragmmentInputsDisplay());
        fragmentTransaction.add(R.id.fragmentParentViewGroup, new FragmmentDisplayCAP());
        //fragmentTransaction.commit();
    }

    public Model initializeModelManger(){
        StudentInformation initialData ;
        initialData = new StudentInformation();
        return new Model(initialData);
    }
    
    @Override
    public void getInput(String text) {
        System.out.println(text);
        modelManger.updateNumOfMods(Integer.parseInt(text));
        FragmmentDisplayCAP display = (FragmmentDisplayCAP) getFragmentManager().findFragmentById(R.id.fragment4);
        display.updateGPA(Integer.parseInt(text));
        
    }
}
