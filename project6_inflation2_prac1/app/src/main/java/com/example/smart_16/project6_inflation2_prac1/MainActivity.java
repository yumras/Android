package com.example.smart_16.project6_inflation2_prac1;

import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout child;
    RadioGroup radioGroup, radioGroup2;
    LayoutInflater inflater;
    Button btn1;
    TextView textResult;
    EditText editText1, editText2, editText3, editText4;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, radioButton7, radioButton8, radioButton9;
    RatingBar ratingBar;
    Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.btn1);
        textResult = (TextView)findViewById(R.id.textResult);

        radioButton1 = (RadioButton)findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton)findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton)findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton)findViewById(R.id.radioButton4);
        radioButton5 = (RadioButton)findViewById(R.id.radioButton5);
        radioButton6 = (RadioButton)findViewById(R.id.radioButton6);
        radioButton7 = (RadioButton)findViewById(R.id.radioButton7);
        radioButton8 = (RadioButton)findViewById(R.id.radioButton8);
        radioButton9 = (RadioButton)findViewById(R.id.radioButton9);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        switch1 = (Switch)findViewById(R.id.switch1);
        radioGroup2 = findViewById(R.id.radioGroup2);

        child = findViewById(R.id.childLayout01);   //인플레이터 생성
        inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.sub1,null);
        child.addView(view);

        radioGroup = findViewById(R.id.radioGroup01);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                View view = null;
                if( i == R.id.radioButton1) { //교수 버튼을 눌렀을때
                    Toast.makeText(getBaseContext(), "교수 선택됨", Toast.LENGTH_SHORT).show();
                    //교수 레이아웃 추가
                    view = inflater.inflate(R.layout.sub1, null);

                } else if ( i == R.id.radioButton2) { //학생 버튼을 눌렀을때
                    Toast.makeText(getBaseContext(), "학생 선택됨", Toast.LENGTH_SHORT).show();
                    //학생 레이아웃 추가
                    view = inflater.inflate(R.layout.sub2, null);
                }
                child.removeAllViews();
                child.addView(view);
            }
        });

/*
        if(radioButton1.isChecked()) { //교수 버튼을 눌렀을때

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editText1 = (EditText) child.findViewById(R.id.editText1);
                    editText2 = (EditText) child.findViewById(R.id.editText2);

                    Toast.makeText(getBaseContext(), "afds", Toast.LENGTH_SHORT).show();

                    textResult.setText("사번은 "+editText1.getText().toString()+" , 이름은 "+editText2.getText().toString()+"입니다.");

                }
            });

        } else if (radioButton2.isChecked()) {
            editText3 = (EditText) child.findViewById(R.id.editText3);
            editText4 = (EditText) child.findViewById(R.id.editText4);

        }
*/







    }
}
