package com.example.smartsolt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class SensorFragment extends Fragment {

    ZlistVO vo;

    public SensorFragment(ZlistVO vo) {
        this.vo = vo;
    }

    TextView tv_z_salinity_now, tv_z_indoor_temp_now, tv_z_indoor_humid_now, tv_z_water_temp_now,
    tv_z_wire_temp_now, tv_z_water_high_now;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sensor, container, false);

        tv_z_salinity_now = view.findViewById(R.id.tv_z_salinity_now);
        tv_z_indoor_temp_now = view.findViewById(R.id.tv_z_indoor_temp_now);
        tv_z_indoor_humid_now = view.findViewById(R.id.tv_z_indoor_humid_now);
        tv_z_water_temp_now = view.findViewById(R.id.tv_z_water_temp_now);
        tv_z_wire_temp_now = view.findViewById(R.id.tv_z_wire_temp_now);
        tv_z_water_high_now = view.findViewById(R.id.tv_z_water_high_now);

        tv_z_salinity_now.setText(vo.getZ_salinity());
        tv_z_indoor_temp_now.setText(vo.getTv_z_indoor_temp());
        tv_z_indoor_humid_now.setText(vo.getZ_indoor_humid());
        tv_z_water_temp_now.setText(vo.getZ_water_temp());
        tv_z_wire_temp_now.setText(vo.getZ_wire_temp());
        tv_z_water_high_now.setText(vo.getZ_water_high());

        return view;
    }
}