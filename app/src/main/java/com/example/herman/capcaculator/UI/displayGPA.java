package com.example.herman.capcaculator.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.herman.capcaculator.R;
import com.example.herman.capcaculator.logic.Logic;

import java.util.logging.Level;
import java.util.logging.Logger;

public class displayGPA extends AppCompatActivity {
    private final Logger logger = Logger.getLogger(displayGPA.class.getName());
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_gp);
        TextView displayGPA = (TextView) findViewById(R.id.displayGPA);
        String passedArg= getIntent().getExtras().getString("key");
        logger.log(Level.INFO, "The passed arguement is:" + passedArg);
        
        displayGPA.setText(passedArg);
    }
}
