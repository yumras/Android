package com.example.smart_16.exam345_66;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //변수 선언
    CheckBox checkAgree;
    TextView textView3,textView4, textView5,textView6,textView7;
    EditText editText1, editText2, editText3, editText4;
    RadioGroup Rgroup1;
    RadioButton radioButton1, radioButton2, radioButton3;
    Button btnCalc;

    //계산에 이용될 변수
    double morning, lunch, dinner, total, input, result;
    String  result1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // id 값 찾아서 변수에 저장하기
        checkAgree = (CheckBox)findViewById(R.id.checkAgree);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView4 = (TextView)findViewById(R.id.textView4);
        textView5 = (TextView)findViewById(R.id.textView5);
        textView6 = (TextView)findViewById(R.id.textView6);
        textView7 = (TextView)findViewById(R.id.textView7);
        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        editText4 = (EditText)findViewById(R.id.editText4);
        Rgroup1 = (RadioGroup)findViewById(R.id.Rgroup1);
        radioButton1 = (RadioButton)findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton)findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton)findViewById(R.id.radioButton3);
        btnCalc = (Button)findViewById(R.id.btnCalc);
        RadioButton selectedRdo = (RadioButton)findViewById(Rgroup1.getCheckedRadioButtonId());
        input = 1;


        checkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(checkAgree.isChecked() == true){
                    textView3.setVisibility(View.VISIBLE);
                    textView4.setVisibility(View.VISIBLE);
                    textView5.setVisibility(View.VISIBLE);
                    textView6.setVisibility(View.VISIBLE);
                    textView7.setVisibility(View.VISIBLE);
                    editText1.setVisibility(View.VISIBLE);
                    editText2.setVisibility(View.VISIBLE);
                    editText3.setVisibility(View.VISIBLE);
                    editText4.setVisibility(View.VISIBLE);
                    radioButton1.setVisibility(View.VISIBLE);
                    radioButton2.setVisibility(View.VISIBLE);
                    radioButton3.setVisibility(View.VISIBLE);
                    btnCalc.setVisibility(View.VISIBLE);
                } else {
                    textView3.setVisibility(View.INVISIBLE);
                    textView4.setVisibility(View.INVISIBLE);
                    textView5.setVisibility(View.INVISIBLE);
                    textView6.setVisibility(View.INVISIBLE);
                    textView7.setVisibility(View.INVISIBLE);
                    editText1.setVisibility(View.INVISIBLE);
                    editText2.setVisibility(View.INVISIBLE);
                    editText3.setVisibility(View.INVISIBLE);
                    editText4.setVisibility(View.INVISIBLE);
                    radioButton1.setVisibility(View.INVISIBLE);
                    radioButton2.setVisibility(View.INVISIBLE);
                    radioButton3.setVisibility(View.INVISIBLE);
                    btnCalc.setVisibility(View.INVISIBLE);
                }


            }
        });



        if(radioButton1.isChecked()){
            input = 1.2;
        }else if(radioButton2.isChecked()){
            input = 1.35;
        }else if(radioButton3.isChecked()){
            input = 1.5;
        };

        Rgroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton1:
                        input = 1.2;
                        break;
                    case R.id.radioButton2:
                        input = 1.35;
                        break;
                    case R.id.radioButton3:
                        input = 1.5;
                        break;

                }
            }
        });


        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                morning = Double.parseDouble(editText2.getText().toString());
                lunch = Double.parseDouble(editText3.getText().toString());
                dinner = Double.parseDouble(editText4.getText().toString());
                total = morning + lunch + dinner;
                result = total * input;
                result1 = Double.toString(result);
                textView7.setText(editText1.getText().toString() + "님의 총 칼로리 섭취량은 " + result1 );
            }
        });




    }
}
