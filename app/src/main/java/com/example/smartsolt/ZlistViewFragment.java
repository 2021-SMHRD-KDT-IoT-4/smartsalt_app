package com.example.smartsolt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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
import java.util.List;


public class ZlistViewFragment extends Fragment {

    ListView lv;
    List<ZlistVO> data;
    RequestQueue requestQueue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_zlist_view, container, false);

        lv = view.findViewById(R.id.lv);

        data = new ArrayList<>();

        ZlistAdapter zdapter = new ZlistAdapter(getActivity().getApplicationContext(), R.layout.zlist, data);

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
                        Log.d("증발지세부내용", response);

                        try {
                            JSONObject json = new JSONObject(response);
                            JSONArray json2 = json.getJSONArray("GetAll_Z_Detail_Info.do");

                            for (int i = 0; i < json2.length(); i++) {
                                JSONObject json3 = (JSONObject) json2.get(i);
                                String numbering = json3.getString("numbering");
                                String z_salinity = json3.getString("z_salinity");
                                String z_indoor_temp = json3.getString("z_indoor_temp");
                                String z_indoor_humid = json3.getString("z_indoor_humid");
                                String z_water_temp = json3.getString("z_water_temp");
                                String z_wire_temp = json3.getString("z_wire_temp");
                                String z_water_high = json3.getString("z_water_high");
                                String z_place_size = json3.getString("z_place_size");
                                String z_pump_move = json3.getString("z_pump_move");

                                ZlistVO vo = new ZlistVO(numbering, z_salinity, z_indoor_temp,
                                        z_indoor_humid, z_water_temp, z_wire_temp, z_water_high,
                                        z_place_size, z_pump_move);

                                data.add(vo);

                            }

                            zdapter.notifyDataSetChanged();


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }

                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }


        );
        requestQueue.add(request);

        lv.setAdapter(zdapter);
        zdapter.notifyDataSetChanged();
        return view;

    }
}