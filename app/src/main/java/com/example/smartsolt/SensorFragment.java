package com.example.smartsolt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class SensorFragment extends Fragment {

    ZlistVO zvo;
    KlistVO kvo;
    TextView tv_sensor_title;
    public SensorFragment(ZlistVO vo) {
        this.zvo = vo;
    }
    public SensorFragment(KlistVO vo) {this.kvo = vo;}

    TextView tv_z_salinity_now, tv_z_indoor_temp_now, tv_z_indoor_humid_now, tv_z_water_temp_now,
    tv_z_wire_temp_now, tv_z_water_high_now;
    TextView tv_z_salinity_set, tv_z_indoor_temp_set, tv_z_indoor_humid_set, tv_z_water_temp_set,
            tv_z_wire_temp_set, tv_z_water_high_set;
    Button btn_z_salinity_p,btn_z_salinity_m,
            btn_z_indoor_humid_p,btn_z_indoor_humid_m, btn_z_water_temp_p,btn_z_water_temp_m,
            btn_z_wire_temp_p,btn_z_wire_temp_m, btn_z_water_high_p,btn_z_water_high_m;
    int salinity = 0;
    int indoor_humid = 0;
    int water_temp = 0;
    int wire_temp = 0;
    int water_high = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sensor, container, false);

        tv_sensor_title = view.findViewById(R.id.tv_sensor_title);
        
        tv_z_salinity_now = view.findViewById(R.id.tv_z_salinity_now);
        tv_z_indoor_temp_now = view.findViewById(R.id.tv_z_indoor_temp_now);
        tv_z_indoor_humid_now = view.findViewById(R.id.tv_z_indoor_humid_now);
        tv_z_water_temp_now = view.findViewById(R.id.tv_z_water_temp_now);
        tv_z_wire_temp_now = view.findViewById(R.id.tv_z_wire_temp_now);
        tv_z_water_high_now = view.findViewById(R.id.tv_z_water_high_now);

        tv_z_salinity_set = view.findViewById(R.id.tv_z_salinity_set);
        tv_z_indoor_temp_set = view.findViewById(R.id.tv_z_indoor_temp_set);
        tv_z_indoor_humid_set = view.findViewById(R.id.tv_z_indoor_humid_set);
        tv_z_water_temp_set = view.findViewById(R.id.tv_z_water_temp_set);
        tv_z_wire_temp_set = view.findViewById(R.id.tv_z_wire_temp_set);
        tv_z_water_high_set = view.findViewById(R.id.tv_z_water_high_set);

        btn_z_salinity_p = view.findViewById(R.id.btn_z_salinity_p);
        btn_z_salinity_m = view.findViewById(R.id.btn_z_salinity_m);
        btn_z_indoor_humid_p = view.findViewById(R.id.btn_z_indoor_humi_p);
        btn_z_indoor_humid_m = view.findViewById(R.id.btn_z_indoor_humi_m);
        btn_z_water_temp_p = view.findViewById(R.id.btn_z_water_temp_p);
        btn_z_water_temp_m = view.findViewById(R.id.btn_z_water_temp_m);
        btn_z_wire_temp_p = view.findViewById(R.id.btn_z_wire_temp_p);
        btn_z_wire_temp_m = view.findViewById(R.id.btn_z_wire_temp_m);
        btn_z_water_high_p = view.findViewById(R.id.btn_z_water_high_p);
        btn_z_water_high_m = view.findViewById(R.id.btn_z_water_high_m);

        if (zvo != null) {
            tv_z_salinity_now.setText(zvo.getZ_salinity_now());
            tv_z_indoor_temp_now.setText(zvo.getZ_indoor_temp_now());
            tv_z_indoor_humid_now.setText(zvo.getZ_indoor_humid_now());
            tv_z_water_temp_now.setText(zvo.getZ_water_temp_now());
            tv_z_wire_temp_now.setText(zvo.getZ_wire_temp_now());
            tv_z_water_high_now.setText(zvo.getZ_water_high_now());
            
            tv_sensor_title.setText("증발지");
        }
        if(kvo != null){
            tv_z_salinity_now.setText(kvo.getK_salinity_now());
            tv_z_indoor_temp_now.setText(kvo.getK_indoor_temp_now());
            tv_z_indoor_humid_now.setText(kvo.getK_indoor_humid_now());
            tv_z_water_temp_now.setText(kvo.getK_water_temp_now());
            tv_z_wire_temp_now.setText(kvo.getK_wire_temp_now());
            tv_z_water_high_now.setText(kvo.getK_water_high_now());
            tv_sensor_title.setText("결정지");
        }

        tv_z_salinity_set.setText(Integer.toString(salinity));
        tv_z_indoor_temp_set.setText("xx");
        tv_z_indoor_humid_set.setText(Integer.toString(indoor_humid));
        tv_z_water_temp_set.setText(Integer.toString(water_temp));
        tv_z_wire_temp_set.setText(Integer.toString(wire_temp));
        tv_z_water_high_set.setText(Integer.toString(water_high));

        btn_z_salinity_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salinity++;
                tv_z_salinity_set.setText(Integer.toString(salinity));
            }
        });
        btn_z_salinity_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salinity--;
                tv_z_salinity_set.setText(Integer.toString(salinity));
            }
        });
        btn_z_indoor_humid_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indoor_humid++;
                tv_z_indoor_humid_set.setText(Integer.toString(indoor_humid));
            }
        });
        btn_z_indoor_humid_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indoor_humid--;
                tv_z_indoor_humid_set.setText(Integer.toString(indoor_humid));
            }
        });
        btn_z_water_temp_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                water_temp++;
                tv_z_water_temp_set.setText(Integer.toString(water_temp));
            }
        });
        btn_z_water_temp_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                water_temp--;
                tv_z_water_temp_set.setText(Integer.toString(water_temp));
            }
        });
        btn_z_wire_temp_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wire_temp++;
                tv_z_wire_temp_set.setText(Integer.toString(wire_temp));
            }
        });
        btn_z_wire_temp_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wire_temp--;
                tv_z_wire_temp_set.setText(Integer.toString(wire_temp));
            }
        });
        btn_z_water_high_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                water_high++;
                tv_z_water_high_set.setText(Integer.toString(water_high));
            }
        });
        btn_z_water_high_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                water_high--;
                tv_z_water_high_set.setText(Integer.toString(water_high));
            }
        });
        return view;
    }
}