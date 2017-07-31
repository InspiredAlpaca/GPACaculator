package com.example.herman.capcaculator.UI;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.example.herman.capcaculator.R;

import java.util.logging.Level;
import java.util.logging.Logger;


public class FragmentInputsDisplay extends Fragment {
    private final Logger logger = Logger.getLogger(FragmentInputsDisplay.class.getName());
    private EditText currNumMods;
    private EditText currGPA;
    private EditText currNumSU;
    
    getInputsListener onInputsListener; //This will be a placeholder for the activity that implements this interface
    //This is also used for communication between fragment and activity
 /
    public FragmentInputsDisplay() {
        // Required empty public constructor
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inputs_display, container, false);
        currNumMods = (EditText) view.findViewById(R.id.currNumMods);
        currGPA = (EditText) view.findViewById(R.id.currGPA);
        currNumSU = (EditText) view.findViewById(R.id.currNumSU);
        
        Button submit = (Button) view.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logger.log(Level.INFO,"NumMods is: " + currNumMods.getText().toString());
                logger.log(Level.INFO,"CurrGPA is: " + currGPA.getText().toString());
                logger.log(Level.INFO,"NumSU is: " + currNumSU.getText().toString());
                //Calling the inputListener so that main activity can receive this data
                onInputsListener.getInput(currGPA.getText().toString(),currNumMods.getText().toString(),currNumSU.getText().toString());
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onInputsListener = (getInputsListener) context;
    }
    
    
    
}
