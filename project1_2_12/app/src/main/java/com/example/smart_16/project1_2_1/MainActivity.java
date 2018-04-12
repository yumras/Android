package com.example.smart_16.project1_2_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnRem, btnClr;
    TextView textResult;
    String num1, num2;
    Float result;
    //추가한 10개의 버튼을 사용하기 위한 배열 선언
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = { R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3,
            R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7,
            R.id.BtnNum8, R.id.BtnNum9};
    int i;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("테이블 레이아웃 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnRem = (Button) findViewById(R.id.BtnRem);
        btnClr = (Button) findViewById(R.id.BtnClr);

        textResult = (TextView) findViewById(R.id.TextResult);

        //기능 부여 --> 이벤트 --> onTouchListener
        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                //getText() : 입력된 값을 얻기
                //toString() : 문자열화
                result = Float.parseFloat(num1) + Float.parseFloat(num2);
                textResult.setText("계산결과: " + result.toString());
                return false;
            }
        });

        btnSub.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Float.parseFloat(num1) - Float.parseFloat(num2);
                textResult.setText("계산결과: " + result.toString());
                return false;
            }
        });

        btnMul.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Float.parseFloat(num1) * Float.parseFloat(num2);
                textResult.setText("계산결과: " + result.toString());
                return false;
            }
        });

        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(Double.parseDouble(num2) == 0){
                    Toast.makeText
                            (getApplicationContext(), "0 으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                }else {
                    result = Float.parseFloat(num1) / Float.parseFloat(num2);
                    textResult.setText("계산결과: " + result.toString());
                }
                return false;
            }
        });

        btnRem.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Float.parseFloat(num1) % Float.parseFloat(num2);
                textResult.setText("계산결과: " + result.toString());
                return false;
            }
        });


        for (i = 0; i < numBtnIDs.length; i++) {
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
        }


        for (i = 0; i < numBtnIDs.length; i++) {
            final int index; //주의! 꼭 필요함.
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (edit1.isFocused() == true) {
                        num1 = edit1.getText().toString()+ numButtons[index].getText().toString();
                        edit1.setText(num1);

                    } else if (edit2.isFocused() == true) {
                        num2 = edit2.getText().toString()
                                + numButtons[index].getText().toString();
                        edit2.setText(num2);

                    } else {
                        Toast.makeText(getApplicationContext(),
                                "먼저 에디트텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText(" ");
                edit2.setText(" ");
                textResult.setText("계산결과: ");
            }
        });

    }
}
