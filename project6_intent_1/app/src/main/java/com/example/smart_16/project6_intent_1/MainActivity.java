package com.example.smart_16.project6_intent_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    RadioButton rdoSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        setTitle("메인 액티비티 (수정)");

        btn1 = (Button)findViewById(R.id.btnNewActivity);
        rdoSecond = (RadioButton)findViewById(R.id.rdoSecond);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;

                // 두번째화면 불러오기
                if(rdoSecond.isChecked() == true){
                    intent = new Intent(getApplicationContext(), SecondActivity.class);
                } else {
                    intent = new Intent(getApplicationContext(), ThirdActivity.class);
                }

                startActivity(intent);
            }
        });

    }
}
