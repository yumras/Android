package com.example.smart_16.midterprac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText text1, text2;
    Button btn2;
    String sungjuk;
    Integer result;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (EditText)findViewById(R.id.editText1);
        text2 = (EditText)findViewById(R.id.editText2);
        btn2 = (Button)findViewById(R.id.button1);
        textView = (TextView)findViewById(R.id.textView3);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sungjuk=text2.getText().toString();
                result = Integer.parseInt(sungjuk);
                if(result >=90) {
                    textView.setText(text1.getText().toString() +"님의 성적은 A 입니다.");
                } else if(result >=80) {
                    textView.setText(text1.getText().toString() +"님의 성적은 B 입니다.");
                } else if(result >=70) {
                    textView.setText(text1.getText().toString() +"님의 성적은 C 입니다.");
                } else if(result >=60) {
                    textView.setText(text1.getText().toString() + "님의 성적은 D 입니다.");
                } else {
                    textView.setText(text1.getText().toString() + "님의 성적은 F 입니다.");
                }
            }
        });

    }
}
