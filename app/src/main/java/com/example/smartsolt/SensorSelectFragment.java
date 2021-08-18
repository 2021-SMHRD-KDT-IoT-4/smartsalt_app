package com.example.smartsolt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class SensorSelectFragment extends Fragment {

    Button btn_sen1, btn_sen2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sensor_select, container, false);

        btn_sen1 =view.findViewById(R.id.btn_sen1);
        btn_sen2 =view.findViewById(R.id.btn_sen2);

        btn_sen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MainActivity)getActivity()).changeFragment(new ZlistViewFragment());

            }
        });

        btn_sen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).changeFragment(new SensorFragment());
            }
        });




        return view;
    }
}