package com.example.smartsolt;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ZlistAdapter extends BaseAdapter {



    Context context;
    int layout;
    List<ZlistVO> data;

    LayoutInflater inflater;



    public  ZlistAdapter(Context context, int layout, List<ZlistVO> data){
        this.context = context;
        this.layout = layout;
        this.data = data;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() { return  data.size();
    }

    @Override
    public Object getItem(int position) { return  data.get(position);
    }

    @Override
    public long getItemId(int position) { return  position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = inflater.inflate(layout, null);
        }

        TextView z_numbering = convertView.findViewById(R.id.tv_z_numbering);
        TextView z_indoorTemp = convertView.findViewById(R.id.tv_z_indoor_temp);
        TextView z_waterTemp = convertView.findViewById(R.id.tv_z_water_temp);
        Button btn_move_sen = convertView.findViewById(R.id.btn_move_sen);
        Button  btn_move_con = convertView.findViewById(R.id.btn_move_con);

        z_numbering.setText(data.get(position).getZ_numbering());
        z_indoorTemp.setText(data.get(position).getZ_indoor_temp_now());
        z_waterTemp.setText(data.get(position).getZ_water_temp_now());

        SharedPreferences spf = context.getSharedPreferences("mySPF", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = spf.edit();
        String con_sen = spf.getString("con_sen",null);

        if (con_sen.equals("c")){
            btn_move_sen.setVisibility(View.INVISIBLE);
        }else{
            btn_move_con.setVisibility(View.INVISIBLE);
        }

        btn_move_sen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Fragment로 넘어가기 위해서는 MainActivity에 만들어둔 changeFrament에 접근
                // Activity정보는 context에 담겨있으므로 context를 MainActivity로 캐시팅후 사용
                ((MainActivity)context).changeFragment(new SensorFragment(data.get(position)));// ★★★★★★★


            }
        });
        btn_move_con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)context).changeFragment(new ConFragment2());
            }
        });
        return convertView;
    }
}
