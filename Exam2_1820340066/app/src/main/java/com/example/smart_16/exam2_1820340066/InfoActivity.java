package com.example.smart_16.exam2_1820340066;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class InfoActivity extends AppCompatActivity{

    MainActivity.myDBHelper myHelper;
    EditText edtMajor, edtNumber, edtName;
    Button btnOK;
    Intent intent;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        edtMajor = (EditText) findViewById(R.id.edtMajor);
        edtNumber = (EditText) findViewById(R.id.edtNumber);
        edtName = (EditText) findViewById(R.id.edtName);

        myHelper = new MainActivity.myDBHelper(this);

        btnOK = (Button)findViewById(R.id.btnOK);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO student VALUES ( '"
                        + edtMajor.getText().toString() + "', '"
                        + edtNumber.getText().toString() + "', '"
                        + edtName.getText().toString() + "');");
                sqlDB.close();


                // 메인화면 돌아가기
                intent = new Intent(getApplicationContext(), MainActivity.class);



                finish();
            }
        });


    }

}
