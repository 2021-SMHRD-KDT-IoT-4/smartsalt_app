package com.example.smartsolt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;




public class ConSelectFragment extends Fragment {


    Button btn_con1, btn_con2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_con_select, container, false);

        btn_con1 =view.findViewById(R.id.btn_con1);
        btn_con2 =view.findViewById(R.id.btn_con2);





        btn_con1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MainActivity)getActivity()).changeFragment(new ConFragment());

            }
        });

        btn_con2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).changeFragment(new ConFragment2());
            }
        });


        return view;


    }
}