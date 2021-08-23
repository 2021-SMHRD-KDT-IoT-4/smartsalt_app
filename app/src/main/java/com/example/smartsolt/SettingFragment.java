package com.example.smartsolt;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import java.util.Map;


public class SettingFragment extends Fragment {
    RequestQueue requestQueue;
    Button btn_add_set;
    ListView lv_set;
    ArrayList<SettingVO> data;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        btn_add_set = view.findViewById(R.id.btn_add_set);
        lv_set = view.findViewById(R.id.lv_set);

        btn_add_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).changeFragment2(new SettingAddFragment());

            }
        });

        ArrayList<KlistVO> klist = klist();
        ArrayList<ZlistVO> zlist = zlist();
        for (int i =0; i< klist.size(); i++){
            int klist_numbering = Integer.parseInt(klist.get(i).getK_numbering());
            int klist_size = Integer.parseInt(klist.get(i).getK_place_size());
            int zlist_numbering = Integer.parseInt(zlist.get(i).getZ_numbering());
            int zlist_size = Integer.parseInt(zlist.get(i).getZ_place_size());
            SettingVO vo = new SettingVO(zlist_numbering,zlist_size,klist_numbering,klist_size);
            data.add(vo);
        }
        Log.d("test",data.get(0).getK_numbering()+"");
//        SettingAdapter adapter = new SettingAdapter(getContext(),R.layout.settinglist,data);
//
//        lv_set.setAdapter(adapter);


        return view;
    }
    public ArrayList<KlistVO> klist(){


        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        }
        ArrayList<KlistVO> result = new ArrayList<KlistVO>();
        String url = "http://project-student.ddns.net/Salt/GetAll_K_Detail_Info.do";
        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.d("response",response);
                            JSONObject json = new JSONObject(response);
                            JSONArray json2 = json.getJSONArray("kdata");
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
                                result.add(vo);

                            }


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

        return result;

    }
    public ArrayList<ZlistVO> zlist(){
     ArrayList<ZlistVO> result = new ArrayList<ZlistVO>();

        String url = "http://project-student.ddns.net/Salt/GetAll_Z_Detail_Info.do";
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

                                result.add(vo);

                            }


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
     return result;
    }
}
