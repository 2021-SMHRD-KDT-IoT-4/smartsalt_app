package com.example.smartsolt;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ConFragment extends Fragment {


    Switch sc_con, sc_light, sc_wire, sc_pump2, sc_pump1,sc_fan;
    TextView tv_btnstate, tv_btnstate2, tv_btnstate3, tv_btnstate4, tv_btnstate5, tv_btnstate6;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //inflater = (LayoutInflater)((MainActivity)getActivity()).getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_con_, container, false);


        sc_con = view.findViewById(R.id.sc_con);
        sc_light = view.findViewById(R.id.sc_light);
        sc_wire = view.findViewById(R.id.sc_wire);
        sc_pump2 = view.findViewById(R.id.sc_pump2);
        sc_pump1 = view.findViewById(R.id.sc_pump1);
        sc_fan = view.findViewById(R.id.sc_fan);


        tv_btnstate = view.findViewById(R.id.tv_btnstate);
        tv_btnstate2 = view.findViewById(R.id.tv_btnstate2);
        tv_btnstate3 = view.findViewById(R.id.tv_btnstate3);
        tv_btnstate4 = view.findViewById(R.id.tv_btnstate4);
        tv_btnstate5 = view.findViewById(R.id.tv_btnstate5);
        tv_btnstate6 = view.findViewById(R.id.tv_btnstate6);


        SharedPreferences spf = getActivity().getSharedPreferences("mySPF", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = spf.edit();


        sc_con.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sc_light.setChecked(isChecked);
                    sc_fan.setChecked(isChecked);
                    sc_pump1.setChecked(isChecked);
                    sc_pump2.setChecked(isChecked);
                    sc_wire.setChecked(isChecked);

                    tv_btnstate.setText("켜짐");
                    tv_btnstate.setTextColor(Color.rgb(69,200,74));

                    tv_btnstate2.setText("켜짐");
                    tv_btnstate2.setTextColor(Color.rgb(69,200,74));

                    tv_btnstate3.setText("켜짐");
                    tv_btnstate3.setTextColor(Color.rgb(69,200,74));

                    tv_btnstate4.setText("켜짐");
                    tv_btnstate4.setTextColor(Color.rgb(69,200,74));

                    tv_btnstate5.setText("켜짐");
                    tv_btnstate5.setTextColor(Color.rgb(69,200,74));

                    tv_btnstate6.setText("켜짐");
                    tv_btnstate6.setTextColor(Color.rgb(69,200,74));

                }else{
                    sc_light.setChecked(false);
                    sc_fan.setChecked(false);
                    sc_pump1.setChecked(false);
                    sc_pump2.setChecked(false);
                    sc_wire.setChecked(false);


                    tv_btnstate.setText("꺼짐");
                    tv_btnstate.setTextColor(Color.rgb(220,0,0));

                    tv_btnstate2.setText("꺼짐");
                    tv_btnstate2.setTextColor(Color.rgb(220,0,0));

                    tv_btnstate3.setText("꺼짐");
                    tv_btnstate3.setTextColor(Color.rgb(220,0,0));

                    tv_btnstate4.setText("꺼짐");
                    tv_btnstate4.setTextColor(Color.rgb(220,0,0));

                    tv_btnstate5.setText("꺼짐");
                    tv_btnstate5.setTextColor(Color.rgb(220,0,0));

                    tv_btnstate6.setText("꺼짐");
                    tv_btnstate6.setTextColor(Color.rgb(220,0,0));

                }
                editor.putBoolean("con",isChecked).commit();

            }
        });

        sc_light.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    tv_btnstate2.setText("켜짐");

                }else{
                    tv_btnstate2.setText("꺼짐");

                }
                editor.putBoolean("con2", isChecked).commit();

            }
        });

        sc_wire.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    tv_btnstate3.setText("켜짐");

                }else{
                    tv_btnstate3.setText("꺼짐");

                }
                editor.putBoolean("con3", isChecked).commit();

            }
        });

        sc_pump1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    tv_btnstate5.setText("켜짐");

                }else{
                    tv_btnstate5.setText("꺼짐");

                }
                editor.putBoolean("con5", isChecked).commit();

            }
        });

        sc_pump2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    tv_btnstate4.setText("켜짐");

                }else{
                    tv_btnstate4.setText("꺼짐");

                }
                editor.putBoolean("con4", isChecked).commit();

            }
        });

        sc_fan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    tv_btnstate6.setText("켜짐");

                }else{
                    tv_btnstate6.setText("꺼짐");

                }
                editor.putBoolean("con6", isChecked).commit();

            }
        });



        sc_con.setChecked(spf.getBoolean("con",false));
        sc_light.setChecked(spf.getBoolean("con2",false));
        sc_wire.setChecked(spf.getBoolean("con3",false));
        sc_pump1.setChecked(spf.getBoolean("con5",false));
        sc_pump2.setChecked(spf.getBoolean("con4",false));
        sc_fan.setChecked(spf.getBoolean("con6",false));


        return view;
    }
}