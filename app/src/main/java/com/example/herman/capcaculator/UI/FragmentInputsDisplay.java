package com.example.herman.capcaculator.UI;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.herman.capcaculator.R;

import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FragmentInputsDisplay extends Fragment {
    private final Logger logger = Logger.getLogger(FragmentInputsDisplay.class.getName());
    private EditText currGPA;
    private EditText creditsEarned;
    private EditText modCredit1,modCredit2,modCredit3,modCredit4,modCredit5;
    private TextView forecastedCap;
    Spinner spinner1,spinner2,spinner3,spinner4,spinner5;
    String mod1,mod2,mod3,mod4,mod5; //To get data from spinners
    Button submitNewMods;

    private EditText currNumSUs;
    private EditText currNumMods;
    
    GetSpinnerInputsListener getSpinnerInputsListener;
    getStudentInformationListener onStudentInformationInputsListener; //This will be a placeholder for the activity that implements this interface
    GetGradeCreditInputsListener onGradeCreditListener;
    UpdateForecastCAP updateForecastCAP;
    //This is also used for communication between fragment and activity
    public FragmentInputsDisplay() {
        // Required empty public constructor
    }
    
    /**
     * This interface communicates fragment with main_activity on the input of the student information
     */
    public interface getStudentInformationListener {
        public void onStudentInformationListener(String text, String text2, String text3, String text4);
    }
    
    /**
     * This interface communicate fragment with main_acitivity on the inputs of the spinners
     */
    public interface GetSpinnerInputsListener {
        public void onSpinnerListener(String mod1, String mod2, String mod3, String mod4, String mod5);
    }
    
    public interface GetGradeCreditInputsListener {
        public void onGradeCreditistener(String mod1, String mod2, String mod3, String mod4, String mod5);
    }
    
    public interface UpdateForecastCAP{
        public double getForecastCAP();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inputs_display, container, false);
        forecastedCap = (TextView)view.findViewById(R.id.forecastedCap);
        currGPA = (EditText) view.findViewById(R.id.currGPA);
        creditsEarned = (EditText)view.findViewById(R.id.creditEarned);
        initializeSpinners(view);
        initializeGradeCredit(view);

        currNumMods = (EditText) view.findViewById(R.id.currNumMods);
        currNumSUs = (EditText)view.findViewById(R.id.currNumSU);
        
        currNumMods.setFocusable(false);
        currNumMods.setAlpha(0.5f);
        currNumSUs.setFocusable(false);
        currNumSUs.setAlpha(0.5f);
        currNumMods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currNumMods.setFocusable(true);
                currNumMods.setFocusableInTouchMode(true);
                currNumMods.requestFocus();
                currNumMods.setSelection(currNumMods.getText().toString().length());
                currNumMods.setAlpha(1f);
            
                creditsEarned.setAlpha(0.5f);
                creditsEarned.setFocusable(false);
                creditsEarned.setText("0");
            
            }
        });
        currNumSUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currNumSUs.setFocusable(true);
                currNumSUs.setFocusableInTouchMode(true);
                currNumSUs.requestFocus();
                currNumSUs.setSelection(currNumMods.getText().toString().length());
                currNumSUs.setAlpha(1f);
            
                creditsEarned.setAlpha(0.5f);
                creditsEarned.setFocusable(false);
                creditsEarned.setText("0");
            
            }
        });
        
        creditsEarned.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creditsEarned.setFocusable(true);
                creditsEarned.setFocusableInTouchMode(true);
                creditsEarned.requestFocus();
                creditsEarned.setSelection(creditsEarned.getText().toString().length());
                creditsEarned.setAlpha(1f);
                
                currNumMods.setAlpha(0.5f);
                currNumMods.setFocusable(false);
                currNumMods.setText("0");
                
                currNumSUs.setAlpha(0.5f);
                currNumSUs.setFocusable(false);
                currNumSUs.setText("0");
            }
        });
        
        currNumSUs = (EditText) view.findViewById(R.id.currNumSU);
        

        submitNewMods = (Button) view.findViewById(R.id.submitNewMods); //Submit button
        submitNewMods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //On click will update the data
                onStudentInformationInputsListener.onStudentInformationListener(currGPA.getText().toString(),
                                                                                creditsEarned.getText().toString(),
                                                                                currNumMods.getText().toString(),
                                                                                currNumSUs.getText().toString());//Updates student information into model
                getSpinnerInputsListener.onSpinnerListener(mod1,mod2,mod3,mod4,mod5); //Updates spinners selection into model
                onGradeCreditListener.onGradeCreditistener(modCredit1.getText().toString(),modCredit2.getText().toString(),modCredit3.getText().toString(),modCredit4.getText().toString(),modCredit5.getText().toString());
                double value = updateForecastCAP.getForecastCAP();
                if(Double.isNaN(value)){
                    System.out.println("THIS WORKEDDDD");
                    Toast.makeText(getActivity(), "Please input CAP & credits earned",
                            Toast.LENGTH_LONG).show();
                } else {
                    DecimalFormat df = new DecimalFormat("###0.000");
                    String value2 = df.format(value);
                    forecastedCap.setText(value2);
                }
            }
        });
        //Sets the spinner up for communication
        //first parameter is context, second is data, third is style
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this.getContext() ,R.array.grades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mod1 = getSpinnerSelection(parent,view,position,id);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mod2 = getSpinnerSelection(parent,view,position,id);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mod3 = getSpinnerSelection(parent,view,position,id);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mod4 = getSpinnerSelection(parent,view,position,id);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mod5 = getSpinnerSelection(parent,view,position,id);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onStudentInformationInputsListener = (getStudentInformationListener) context; //Link between main_Activity and fragment
        getSpinnerInputsListener = (GetSpinnerInputsListener) context; //This object will be used to call the method defined in main during button click
        onGradeCreditListener = (GetGradeCreditInputsListener)context;
        updateForecastCAP = (UpdateForecastCAP) context;
    }
    
    /**
     * This method returns the information selected in the respective spinners
     * @param parent
     * @param view
     * @param position
     * @param id
     * @return
     */
    public String getSpinnerSelection(AdapterView<?> parent, View view, int position, long id){
        logger.log(Level.INFO,parent.getItemAtPosition(position).toString());
        return parent.getItemAtPosition(position).toString();
    }
    
    public void initializeSpinners(View view){
        spinner1 = (Spinner) view.findViewById(R.id.spinner1);
        spinner2 = (Spinner) view.findViewById(R.id.spinner2);
        spinner3 = (Spinner) view.findViewById(R.id.spinner3);
        spinner4 = (Spinner) view.findViewById(R.id.spinner4);
        spinner5 = (Spinner) view.findViewById(R.id.spinner5);
    }
    
    public void initializeGradeCredit(View view){
        modCredit1 = (EditText) view.findViewById(R.id.modCredit1);
        modCredit2 = (EditText) view.findViewById(R.id.modCredit2);
        modCredit3 = (EditText) view.findViewById(R.id.modCredit3);
        modCredit4 = (EditText) view.findViewById(R.id.modCredit4);
        modCredit5 = (EditText) view.findViewById(R.id.modCredit5);
    }
    
}
