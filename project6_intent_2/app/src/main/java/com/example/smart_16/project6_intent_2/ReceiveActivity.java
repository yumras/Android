package com.example.smart_16.project6_intent_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReceiveActivity extends AppCompatActivity{
    TextView re_name, re_gender, re_sms;
    Button btn_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("전송된 데이터 결과화면");

        // id 찾기
        re_name=(TextView)findViewById(R.id.re_name);
        re_gender=(TextView)findViewById(R.id.re_gender);
        re_sms=(TextView)findViewById(R.id.re_sms);
        btn_return=(Button)findViewById(R.id.btn_return);

        // intent 받기
        Intent it = getIntent();
        String str_name = it.getStringExtra("it_name");
        re_name.setText(str_name);

        String str_gender = it.getStringExtra("it_gender");
        re_gender.setText(str_gender);

        String str_sms = it.getStringExtra("it_sms");
        re_sms.setText(str_sms);

        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent main = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(main);
                finish();
            }
        });

    }
}
