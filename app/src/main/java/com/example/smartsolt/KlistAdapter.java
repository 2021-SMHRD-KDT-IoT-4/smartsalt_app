package com.example.smartsolt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class KlistAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<KlistVO> data;

    LayoutInflater inflater;

    public KlistAdapter(Context context, int layout, List<KlistVO> data){
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

        TextView k_numbering = convertView.findViewById(R.id.tv_k_numbering);
        TextView k_indoorTemp = convertView.findViewById(R.id.tv_k_indoor_temp);
        TextView k_waterTemp = convertView.findViewById(R.id.tv_k_water_temp);
        Button btn_move_sen_1 = convertView.findViewById(R.id.btn_move_sen_1);

        k_numbering.setText(data.get(position).getK_numbering());
        k_indoorTemp.setText(data.get(position).getK_indoor_temp_now());
        k_waterTemp.setText(data.get(position).getK_water_temp_now());

        btn_move_sen_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Fragment로 넘어가기 위해서는 MainActivity에 만들어둔 changeFrament에 접근
                // Activity정보는 context에 담겨있으므로 context를 MainActivity로 캐시팅후 사용
                ((MainActivity)context).changeFragment(new SensorFragment(data.get(position))); // ★★★★★★★
            }
        });

        return convertView;
    }
}
