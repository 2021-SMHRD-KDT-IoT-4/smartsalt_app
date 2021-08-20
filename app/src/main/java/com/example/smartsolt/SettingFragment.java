package com.example.smartsolt;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class SettingFragment extends Fragment {

    Button btn_add_set;
    ListView lv_set;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        btn_add_set = view.findViewById(R.id.btn_add_set);
        lv_set = view.findViewById(R.id.lv_set);
        SharedPreferences spf = getActivity().getSharedPreferences("mySPF", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = spf.edit();
        btn_add_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).changeFragment2(new SettingAddFragment());

            }
        });

        String[] arr = {spf.getString("set_numbering",null),spf.getString("set_size",null),spf.getString("set_zk",null)};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),R.layout.settinglist,arr);

        lv_set.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return view;
    }
}