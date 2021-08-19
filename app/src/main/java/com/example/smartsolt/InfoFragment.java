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
    int cnt;
    int count;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_info, container, false);

        btn_convert = view.findViewById(R.id.btn_convert);
        tbl_dailyprod = view.findViewById(R.id.tbl_dailyprod);
        tbl_predictday = view.findViewById(R.id.tbl_predictday);

        tbl_predictday.setVisibility(View.GONE);

        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 cnt++;
                count = cnt;
               if (count%2 == 1){
                   tbl_dailyprod.setVisibility(View.GONE);
                   tbl_predictday.setVisibility(View.VISIBLE);
                   btn_convert.setText("일일생산량 확인");
               }else if (count%2 == 0){
                   tbl_dailyprod.setVisibility(View.VISIBLE);
                   tbl_predictday.setVisibility(View.GONE);
                   btn_convert.setText("수확예측일 확인");
               }

            }

        });

        return view;
    }
}