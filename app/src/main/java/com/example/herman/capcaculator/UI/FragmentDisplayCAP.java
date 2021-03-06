package com.example.herman.capcaculator.UI;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.herman.capcaculator.R;

import java.text.DecimalFormat;

import static java.lang.Math.round;

public class FragmentDisplayCAP extends Fragment {
    TextView text;
    displayGPA onDisplayGPA;
    //Interface to communicate with main activity
    public interface displayGPA{
        public double updateCAP();
    }
    public FragmentDisplayCAP() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display_ca, container, false);
        text = (TextView) view.findViewById(R.id.outputGPA);
        double value = onDisplayGPA.updateCAP();
        DecimalFormat df = new DecimalFormat("###0.00");
        String value2 = df.format(value);
        System.out.println(value2);
        text.setText(value2);
        return view;
    }
    
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onDisplayGPA = (displayGPA) context;
    }
}
