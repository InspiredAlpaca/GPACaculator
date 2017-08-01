package com.example.herman.capcaculator.UI;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import com.example.herman.capcaculator.R;

public class inputNewMods extends Fragment {
    Spinner spinner1,spinner2,spinner3,spinner4,spinner5;
    String mod1,mod2,mod3,mod4,mod5;
    Button submitNewMods;
    GetSpinnerInputsListener getSpinnerInputsListener;
    
    public interface GetSpinnerInputsListener {
        public void getSpinnerListener(String mod1,String mod2,String mod3,String mod4,String mod5);
    }
    
    public inputNewMods() {
        // Required empty public constructor
    }
    
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //getSpinnerInputsListener = (GetSpinnerInputsListener) context;
        
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input_new_mods, container, false);
        spinner1 = (Spinner) view.findViewById(R.id.spinner1);
        spinner2 = (Spinner) view.findViewById(R.id.spinner2);
        spinner3 = (Spinner) view.findViewById(R.id.spinner3);
        spinner4 = (Spinner) view.findViewById(R.id.spinner4);
        spinner5 = (Spinner) view.findViewById(R.id.spinner5);
        
        submitNewMods = (Button) view.findViewById(R.id.submitNewMods);
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
        
        submitNewMods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSpinnerInputsListener.getSpinnerListener(mod1,mod2,mod3,mod4,mod5);
            }
        });
        return view;
    }
    
    public String getSpinnerSelection(AdapterView<?> parent, View view, int position, long id){
        System.out.println(parent.getItemAtPosition(position));
        return parent.getItemAtPosition(position).toString();
    }
}

