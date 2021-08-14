package com.example.smartsolt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class selectActivity extends AppCompatActivity {

    Button btn_1, btn_2;
    final int LOGIN_REQUEST= 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);


        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(selectActivity.this, SensorFragment.class);
                startActivityForResult(intent, LOGIN_REQUEST);


            }
        });


    }
}