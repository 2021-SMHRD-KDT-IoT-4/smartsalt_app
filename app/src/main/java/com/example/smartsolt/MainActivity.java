package com.example.smartsolt;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnv;
    LineChart lineChart;

    WebView wv;

    ArrayList<Entry> entry_chart = new ArrayList<>();
    FrameLayout frameLayout1, frameLayout2, frameLayout3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv = findViewById(R.id.bnv);

        wv = findViewById(R.id.wv);

        frameLayout1 = findViewById(R.id.framelayout1);
        frameLayout2 = findViewById(R.id.framelayou2);
        frameLayout3 = findViewById(R.id.framelayou3);

        lineChart = findViewById(R.id.linechart);


        LineData chartData = new LineData();
        // 생산량 데이터 값 받아오기 getTEXT.toString  (꺽은 선 그래프)
        entry_chart.add(new Entry(1, 1));
        entry_chart.add(new Entry(2, 2));
        entry_chart.add(new Entry(3, 0));
        entry_chart.add(new Entry(4, 4));
        entry_chart.add(new Entry(5, 3));
    /* 만약 (2, 3) add하고 (2, 5)한다고해서
    기존 (2, 3)이 사라지는게 아니라 x가 2인곳에 y가 3, 5의 점이 찍힘 */

        LineDataSet lineDataSet = new LineDataSet(entry_chart, "꺽은선1");
        chartData.addDataSet(lineDataSet);

        lineChart.setData(chartData);

        lineChart.invalidate();


        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout1,
                new InfoFragment()).commit();

        frameLayout2.setVisibility(View.INVISIBLE);

        frameLayout2.setVisibility(View.INVISIBLE);
        changeFragment(new InfoFragment());

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.item_con:
                        changeFragment(new ConSelectFragment());
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayou2,
                                new CctvFragment()).commit();
                        lineChart.setVisibility(View.INVISIBLE);
                        frameLayout2.setVisibility(View.VISIBLE);
                        frameLayout3.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.item_info:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout1,
                                new InfoFragment()).commit();

                        lineChart.setVisibility(View.VISIBLE);
                        frameLayout2.setVisibility(View.INVISIBLE);
                        frameLayout3.setVisibility(View.INVISIBLE);

                        break;
                    case R.id.item_sensor:

                        changeFragment(new SensorSelectFragment());
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayou2,
                                new CctvFragment()).commit();
                        lineChart.setVisibility(View.INVISIBLE);
                        frameLayout2.setVisibility(View.VISIBLE);
                        frameLayout3.setVisibility(View.INVISIBLE);
                        frameLayout2.refreshDrawableState();
                        break;
                    case R.id.item_weather:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayou3,
                                new WeatherFragment()).commit();
                        frameLayout3.setVisibility(View.VISIBLE);
                        frameLayout2.setVisibility(View.INVISIBLE);

                }

                return true;
            }
        });


    }
    public void changeFragment(Fragment frag){
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout1,
                frag).commit();
    }
}