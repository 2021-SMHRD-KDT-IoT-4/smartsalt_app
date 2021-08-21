package com.example.smartsolt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SettingAdapter extends BaseAdapter {

    TextView tv_z_num, tv_k_num, tv_z_size,tv_k_size;

    Context context;
    int layout;
    List<SettingVO> data;

    LayoutInflater inflater;

    public SettingAdapter(Context context, int layout, List<SettingVO> data) {
        this.context = context;
        this.layout = layout;
        this.data = data;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = inflater.inflate(layout,null);
        }

        tv_k_num = convertView.findViewById(R.id.tv_k_num);
        tv_z_num = convertView.findViewById(R.id.tv_z_num);
        tv_k_size = convertView.findViewById(R.id.tv_k_size_1);
        tv_z_size = convertView.findViewById(R.id.tv_z_size_1);

        for (int i =0; i <data.size(); i++){
            tv_z_size.setText(data.get(i).getZ_place_size());
            tv_k_size.setText(data.get(i).getK_place_size());
            tv_z_num.setText(data.get(i).getZ_numbering());
            tv_k_num.setText(data.get(i).getK_numbering());
        }


        return convertView;
    }
}
