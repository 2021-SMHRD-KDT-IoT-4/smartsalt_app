package com.example.smartsolt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;

import androidx.fragment.app.Fragment;


public class InfoFragment extends Fragment {

    TableLayout tbl_dailyprod, tbl_predictday;
    Button btn_convert;
    int cnt = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_info, container, false);

        btn_convert = view.findViewById(R.id.btn_convert);
        tbl_dailyprod = view.findViewById(R.id.tbl_dailyprod);
        tbl_predictday = view.findViewById(R.id.tbl_predictday);



        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               cnt =+ 1;

               if (cnt%2 == 1){
                   tbl_dailyprod.getVisibility();
               }

            }
        });

        return view;
    }
}