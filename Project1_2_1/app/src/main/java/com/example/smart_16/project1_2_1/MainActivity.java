package com.example.smart_16.project1_2_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editHeight, editWeight;
    Button btnBMI;
    TextView Height, Weight, textResult1, textResult2;
    String num1, num2;
    Float result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("BMI 계산기");

        editHeight = (EditText) findViewById(R.id.editHeight);
        editWeight = (EditText) findViewById(R.id.editWeight);

        btnBMI = (Button) findViewById(R.id.btnBMI);

        textResult1 = (TextView) findViewById(R.id.textResult1);
        textResult2 = (TextView) findViewById(R.id.textResult2);

        btnBMI.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = editHeight.getText().toString();
                num2 = editWeight.getText().toString();
                //getText() : 입력된 값을 얻기
                //toString() : 문자열화
                result = Float.parseFloat(num2) / ((Float.parseFloat(num1)/100)*(Float.parseFloat(num1)/100)) ;
                textResult1.setText("BMI: " + result.toString());
                if(result<18.5){
                    textResult2.setText("저체중입니다.");
                }else if(result>=18.5 && result<22.9){
                    textResult2.setText("정상입니다.");
                }else{
                    textResult2.setText("비만입니다.");
                }
                return false;
            }
        });


    }
}
