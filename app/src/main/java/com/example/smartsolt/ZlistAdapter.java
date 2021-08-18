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

        z_numbering.setText(data.get(position).getTv_z_numbering());
        z_indoorTemp.setText(data.get(position).getTv_z_indoor_temp());
        z_waterTemp.setText(data.get(position).getZ_water_temp());

        return convertView;
    }
}
