package com.example.smartsolt;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class SettingAddFragment extends Fragment {


    EditText z_et_add_size, k_et_add_size;
    Button btn_add;
    String id;
    int z_size, k_size;
    RequestQueue requestQueue;
    ArrayList<SettingVO> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_setting_add, container, false);

        z_et_add_size = view.findViewById(R.id.et_z_add_size);
        k_et_add_size = view.findViewById(R.id.et_k_add_size);
        btn_add = view.findViewById(R.id.btn_add_setting);

        z_size = Integer.parseInt(z_et_add_size.getText().toString());
        k_size = Integer.parseInt(k_et_add_size.getText().toString());

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue((MainActivity)getActivity());

        }

        SharedPreferences spf = getActivity().getSharedPreferences("mySPF", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = spf.edit();


        SettingVO vo = new SettingVO(id,z_size,k_size);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = spf.getString("id",null);

                String url = "http://project-student.ddns.net/Salt/InsertSaltern.do";
                StringRequest request = new StringRequest(
                        Request.Method.POST,
                        url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if (response.equals("1")) {

                                    Toast.makeText((MainActivity)getActivity(), "전송성공", Toast.LENGTH_SHORT).show();


                                } else {

                                    Toast.makeText((MainActivity)getActivity(), "전송실패", Toast.LENGTH_SHORT).show();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText((MainActivity)getActivity(), "실패", Toast.LENGTH_SHORT).show();
                            }
                        }
                ){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> params = new HashMap<>();
                        params.put("id", id);
                        params.put("z_size", z_size+"");
                        params.put("k_size",k_size+"");
                        params.put("req", "1");


                        return params;
                    }

                };

                requestQueue.add(request);


            }
        });


        return view;
    }
}