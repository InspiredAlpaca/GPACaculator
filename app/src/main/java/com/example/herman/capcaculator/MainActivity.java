package com.example.herman.capcaculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.herman.capcaculator.UI.UiManger;
import com.example.herman.capcaculator.logic.Logic;
import com.example.herman.capcaculator.model.Model;
import com.example.herman.capcaculator.model.StudentInformation;

public class MainActivity extends AppCompatActivity {
    protected Logic logicManager;
    protected Model modelManger;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Located in Resource.Layout folder
        modelManger = initializeModelManger();
        logicManager = new Logic(this,modelManger);
        UiManger uiManger = new UiManger(logicManager);
    }
    //Added another comment
    //Test comment to push onto git
    public Model initializeModelManger(){
        StudentInformation initialData ;
        initialData = new StudentInformation();
        return new Model(initialData);
    }
    
}
