package com.example.smartsolt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
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

        TextView tv_z_numbering = convertView.findViewById(R.id.tv_z_numbering);
        TextView tv_z_name = convertView.findViewById(R.id.tv_z_name);
        TextView tv_z_indoor_temp = convertView.findViewById(R.id.tv_z_indoor_temp);
        TextView btn_move_con = convertView.findViewById(R.id.btn_move_con);
        TextView btn_move_sen = convertView.findViewById(R.id.btn_move_sen);

        tv_z_numbering.setText(data.get(position).getTv_z_numbering());
        tv_z_name.setText(data.get(position).getTv_z_name());
        tv_z_indoor_temp.setText(data.get(position).getTv_z_indoor_temp());
        btn_move_con.setText(data.get(position).getBtn_move_con());
        btn_move_sen.setText(data.get(position).getBtn_move_sen());



        return convertView;
    }
}
