package com.example.smartsolt;

import android.content.Context;
import android.text.Layout;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class ConAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<ConVO> data;

    LayoutInflater inflater;

    public ConAdapter(Context context, int layout, List<ConVO> data) {
        this.context = context;
        this.layout = layout;
        this.data = data;
        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
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

        if (convertView == null){

            convertView = inflater.inflate(layout, null);
        }

           TextView tv_name = convertView.findViewById(R.id.tv_name);

         tv_name.setText(data.get(position).getConName());

        return convertView;
    }
}