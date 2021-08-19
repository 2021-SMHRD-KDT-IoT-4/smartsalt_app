package com.example.smartsolt;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KlistViewFragment extends Fragment {

    ListView lv;
    List<KlistVO> data;
    RequestQueue requestQueue;
    KlistAdapter kdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_klist_view, container, false);
        lv = view.findViewById(R.id.klv);

        data = new ArrayList<>();
        kdapter = new KlistAdapter(getContext(), R.layout.klist, data);

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        }



        String url = "http://192.168.1.20:8084/Project/GetAll_K_Detail_Info.do";
        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject json = new JSONObject(response);
                            Log.d("json",json.toString());
                            JSONArray json2 = json.getJSONArray("data");
                            Log.d("data",json2.toString());
                            for (int i = 0; i < json2.length(); i++) {
                                JSONObject json3 = (JSONObject) json2.get(i);
                                String numbering = json3.getString("numbering");
                                String k_dail_prod = json3.getString("k_daily_prod");
                                String k_harvest = json3.getString("k_harvest");
                                String k_place_size = json3.getString("k_place_size");
                                String k_automode = json3.getString("k_automode");
                                String node = json3.getString("node");

                                String k_salinity_now = json3.getString("k_salinity");
                                String k_indoor_temp_now = json3.getString("k_indoor_temp");
                                String k_indoor_humid_now = json3.getString("k_indoor_humid");
                                String k_water_temp_now = json3.getString("k_water_temp");
                                String k_wire_temp_now = json3.getString("k_wire_temp");
                                String k_water_high_now = json3.getString("k_water_high");

                                KlistVO vo = new KlistVO(numbering,k_dail_prod,k_harvest,k_place_size,k_automode,node,
                                        k_salinity_now,k_indoor_temp_now,k_indoor_humid_now,k_water_temp_now,
                                        k_wire_temp_now,k_water_high_now);
                                data.add(vo);

                            }
                            kdapter.notifyDataSetChanged();


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "실패", Toast.LENGTH_SHORT).show();

                    }
                }

        ) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("req", "1");


                return params;
            }
        };
        requestQueue.add(request);


        lv.setAdapter(kdapter);


        return view;
    }
}