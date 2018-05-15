package com.example.smart_16.project6_intent_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    EditText edit1;
    Button btn1;
    RadioButton r1, r2;
    CheckBox chk_SMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // id 찾기
        edit1 = (EditText)findViewById(R.id.edit1);
        btn1 = (Button)findViewById(R.id.btn1);
        r1 = (RadioButton)findViewById(R.id.radio_male);
        r2 = (RadioButton)findViewById(R.id.radio_female);
        chk_SMS = (CheckBox)findViewById(R.id.checkbox_sms);

        // 기능 부여
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_name = edit1.getText().toString();
                String str_gender = "";
                if (r1.isChecked()==true){
                    str_gender="남";
                }
                if (r2.isChecked()==true){
                    str_gender="여";
                }
                String str_sms="";
                if (chk_SMS.isChecked()){
                    str_sms = "수신함";
                }

                Intent it = new Intent(getApplicationContext(), ReceiveActivity.class);
                it.putExtra("it_name", str_name); // 변수명 = 값;
                it.putExtra("it_gender", str_gender);
                it.putExtra("it_sms", str_sms);
                startActivity(it);
                finish();
            }
        });



    }
}
