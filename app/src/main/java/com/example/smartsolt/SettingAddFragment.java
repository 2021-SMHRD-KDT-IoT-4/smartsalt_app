package com.example.smartsolt;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class SettingAddFragment extends Fragment {


    EditText et_add_numbering, et_add_size;
    Button btn_add;
    String numbering,size, zk;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_setting_add, container, false);

        et_add_numbering = view.findViewById(R.id.et_z_add_numbering);
        et_add_size = view.findViewById(R.id.et_z_add_size);
        btn_add = view.findViewById(R.id.btn_add_setting);
        SharedPreferences spf = getActivity().getSharedPreferences("mySPF", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = spf.edit();

        numbering = et_add_numbering.getText().toString();
        size = et_add_size.getText().toString();


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("set_numbering",numbering);
                editor.putString("set_size",size);
                editor.putString("set_zk",zk);
                editor.commit();
                ((MainActivity)getActivity()).changeFragment2(new SettingFragment());
            }
        });

        return view;
    }
}