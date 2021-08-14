package com.example.smartsolt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText edt_id, edt_pw;
    Button btn_loginCheck;
    final int LOGIN_REQUEST = 2002;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        btn_loginCheck = findViewById(R.id.btn_loginCheck);

        btn_loginCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 클릭했을 떄 사용자가 입력한 id,pw를 변수에 저장

                String id = edt_id.getText().toString();
                String pw = edt_pw.getText().toString();

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivityForResult(intent, LOGIN_REQUEST);


                // 임의의 값인 'smhrd', '1234'와 비교
                if(id.equals("smhrd")&& pw.equals("1234")){
                    // 일치한 경우, '인쌤' 닉네임을 이전 화면으로 전달
                    intent.putExtra("nick","인썜");
                    setResult(RESULT_OK, intent);


                }else{
                    setResult(RESULT_CANCELED, intent);
                }
                finish();

            }
        });


    }
}