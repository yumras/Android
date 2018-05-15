package com.example.smart_16.project6_intent_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("메인");

        Button btn1 = (Button)findViewById(R.id.button);
        final EditText edtNum1 = (EditText)findViewById(R.id.edtNum1);
        final EditText edtNum2 = (EditText)findViewById(R.id.edtNum2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 인텐트 실행
                Intent intent = new Intent(getApplicationContext(),result.class);
                intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));
                // 달라지는 부분
                startActivityForResult(intent, 0);
            }
        });
    }

    // 메인으로 돌아왔을때 메서드 오버라이딩
    // code - override methods ==> onActivityResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 성공여부 체크 후 결과 출력
        if(resultCode== RESULT_OK){
            int hap = data.getIntExtra("Hap",0);
            Toast.makeText(getApplicationContext(),"합계"+hap,Toast.LENGTH_SHORT).show();
        }

    }
}
