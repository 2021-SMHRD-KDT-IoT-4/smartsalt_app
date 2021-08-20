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


public class ZlistViewFragment extends Fragment {

    ListView lv;
    List<ZlistVO> data;
    RequestQueue requestQueue;
    ZlistAdapter zdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        View view = inflater.inflate(R.layout.fragment_zlist_view, container, false);

        lv = view.findViewById(R.id.zlv);

        data = new ArrayList<>();
        zdapter = new ZlistAdapter(getContext(), R.layout.zlist, data);

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        }



        String url = "http://192.168.1.20:8084/Project/GetAll_Z_Detail_Info.do";
        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject json = new JSONObject(response);

                            JSONArray json2 = json.getJSONArray("data");
                            Log.d("data",json2.toString());
                            for (int i = 0; i < json2.length(); i++) {
                                JSONObject json3 = (JSONObject) json2.get(i);
                                String numbering = json3.getString("numbering");
                                String z_place_size_now = json3.getString("z_place_size");
                                String z_pump_move_now = json3.getString("z_pump_move");
                                String z_salinity_now = json3.getString("z_salinity");
                                String z_indoor_temp_now = json3.getString("z_indoor_temp");
                                String z_indoor_humid_now = json3.getString("z_indoor_humid");
                                String z_water_temp_now = json3.getString("z_water_temp");
                                String z_wire_temp_now = json3.getString("z_wire_temp");
                                String z_water_high_now = json3.getString("z_water_high");

                                ZlistVO vo = new ZlistVO(numbering, z_place_size_now,z_pump_move_now,z_salinity_now,
                                        z_indoor_temp_now,z_indoor_humid_now,z_water_temp_now,z_wire_temp_now,z_water_high_now);

                                data.add(vo);

                            }
                            zdapter.notifyDataSetChanged();


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


        lv.setAdapter(zdapter);



        return view;

    }
}