package com.example.smart_16.project1_1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //변수 선언 자료형 변수명;
    Button button1;
    Button button2, button3;
    TextView tv1, tv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // activity_mail.xml에 있는 id값 찾아서 변수에 저장하기
        button1 = (Button) findViewById(R.id.button1); //res에서 id 값을 button1찾음
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        tv1 = (TextView) findViewById(R.id.textView1);
        tv2 = (TextView) findViewById(R.id.textView2);

        //위젯에 이벤트 부여하기
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText
                        (getApplicationContext(), "하이", Toast.LENGTH_SHORT).show();
                //Toast : 메시지 보여주는 클래스
                //makeText() : 메시지를 만들어줌
                //getApplicationContext() : 실행되는 어플리케이션의 내용으로
                //Toast.Length_short : 메시지길이(보여지는 길이)
                //show() : 보여주기
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText
//                        (getApplicationContext(), "Hello", Toast.LENGTH_SHORT).show();
                tv1.setText("자기이름"); //변경하고자 하는 텍스트
                tv2.setText("자기소개를 작성하기");
                tv1.setTextColor(Color.MAGENTA);
                tv1.setTextSize(30);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText
                        (getApplicationContext(), "안녕하세요, 반갑습니다. 저는 박찬호입니다. " +
                                "핸드폰 하니 제가 LA에서 야구하던 시절...[더보기]", Toast.LENGTH_LONG).show();
            }
        });


    }
}
