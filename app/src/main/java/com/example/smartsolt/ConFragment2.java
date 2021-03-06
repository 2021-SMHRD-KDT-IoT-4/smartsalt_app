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


public class ConFragment2 extends Fragment {

    Switch sc_con_2, sc_light_2, sc_wire_2, sc_pump2_2, sc_pump1_2,sc_fan_2;
    TextView tv_btnstate_2, tv_btnstate2_2, tv_btnstate3_2, tv_btnstate4_2, tv_btnstate5_2, tv_btnstate6_2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_con2, container, false);

        sc_con_2 = view.findViewById(R.id.sc_con_2);
        sc_light_2 = view.findViewById(R.id.sc_light_2);
        sc_wire_2 = view.findViewById(R.id.sc_wire_2);
        sc_pump2_2 = view.findViewById(R.id.sc_pump2_2);
        sc_pump1_2 = view.findViewById(R.id.sc_pump1_2);
        sc_fan_2 = view.findViewById(R.id.sc_fan_2);


        tv_btnstate_2 = view.findViewById(R.id.tv_btnstate_2);
        tv_btnstate2_2 = view.findViewById(R.id.tv_btnstate2);
        tv_btnstate3_2 = view.findViewById(R.id.tv_btnstate3_2);
        tv_btnstate4_2 = view.findViewById(R.id.tv_btnstate4_2);
        tv_btnstate5_2 = view.findViewById(R.id.tv_btnstate5_2);
        tv_btnstate6_2 = view.findViewById(R.id.tv_btnstate6_2);

        SharedPreferences spf = getActivity().getSharedPreferences("mySPF", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = spf.edit();


        sc_con_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sc_light_2.setEnabled(true);
                    sc_fan_2.setEnabled(true);
                    sc_pump1_2.setEnabled(true);
                    sc_pump2_2.setEnabled(true);
                    sc_wire_2.setEnabled(true);

                    tv_btnstate_2.setText("?????????");
                    tv_btnstate_2.setTextColor(Color.rgb(69,200,74));


                    sc_light_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                            if(isChecked){
                                tv_btnstate2_2.setText("??????");

                            }else{
                                tv_btnstate2_2.setText("??????");

                            }
                            editor.putBoolean("con2_2", isChecked).commit();

                        }
                    });

                    sc_wire_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                            if(isChecked){
                                tv_btnstate3_2.setText("??????");

                            }else{
                                tv_btnstate3_2.setText("??????");

                            }
                            editor.putBoolean("con3_2", isChecked).commit();

                        }
                    });

                    sc_pump1_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                            if(isChecked){
                                tv_btnstate5_2.setText("??????");

                            }else{
                                tv_btnstate5_2.setText("??????");

                            }
                            editor.putBoolean("con5_2", isChecked).commit();

                        }
                    });

                    sc_pump2_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                            if(isChecked){
                                tv_btnstate4_2.setText("??????");

                            }else{
                                tv_btnstate4_2.setText("??????");

                            }
                            editor.putBoolean("con4_2", isChecked).commit();

                        }
                    });

                    sc_fan_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                            if(isChecked){
                                tv_btnstate6_2.setText("??????");

                            }else{
                                tv_btnstate6_2.setText("??????");

                            }
                            editor.putBoolean("con6_2", isChecked).commit();

                        }
                    });


                }else{
                    sc_light_2.setEnabled(false);
                    sc_fan_2.setEnabled(false);
                    sc_pump1_2.setEnabled(false);
                    sc_pump2_2.setEnabled(false);
                    sc_wire_2.setEnabled(false);


                    tv_btnstate_2.setText("????????????");
                    tv_btnstate_2.setTextColor(Color.rgb(220,0,0));



                }
                editor.putBoolean("con_2",isChecked).commit();

            }
        });




        sc_con_2.setChecked(spf.getBoolean("con_2",false));
        sc_light_2.setChecked(spf.getBoolean("con2_2",false));
        sc_wire_2.setChecked(spf.getBoolean("con3_2",false));
        sc_pump1_2.setChecked(spf.getBoolean("con5_2",false));
        sc_pump2_2.setChecked(spf.getBoolean("con4_2",false));
        sc_fan_2.setChecked(spf.getBoolean("con6_2",false));

        boolean checkState = spf.getBoolean("con_2",false);

        if(checkState){
            sc_light_2.setEnabled(true);
            sc_fan_2.setEnabled(true);
            sc_pump1_2.setEnabled(true);
            sc_pump2_2.setEnabled(true);
            sc_wire_2.setEnabled(true);
        }else{
            sc_light_2.setEnabled(false);
            sc_fan_2.setEnabled(false);
            sc_pump1_2.setEnabled(false);
            sc_pump2_2.setEnabled(false);
            sc_wire_2.setEnabled(false);

        }
        return view;
    }
}