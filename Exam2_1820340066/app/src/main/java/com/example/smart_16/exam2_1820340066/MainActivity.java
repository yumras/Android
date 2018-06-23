package com.example.smart_16.exam2_1820340066;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    myDBHelper myHelper; // DB 정보 가져옴
    EditText findMajor, edtNameResult, edtNumberResult;
    Button btnInsert,btnSelect;
    Intent intent;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("학생관리 프로그램");

        findMajor = (EditText)findViewById(R.id.findMajor);
        edtNameResult = (EditText)findViewById(R.id.edtNameResult);
        edtNumberResult = (EditText)findViewById(R.id.edtNumberResult);
        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnSelect = (Button)findViewById(R.id.btnSelect);

        myHelper = new myDBHelper(this);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // intent
                intent = new Intent(getApplicationContext(), InfoActivity.class);
                startActivity(intent);
            }
        });

        // select 기능
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM student where major = '"+findMajor.getText().toString()+"' ;", null);

                String strNumbers ="학번" + "\r\n" + "___" + "\r\n";
                String strNames ="이름" + "\r\n" + "___" + "\r\n";
                int count = 0;

                while (cursor.moveToNext()){
                    strNumbers += cursor.getString(1) + "\r\n";
                    strNames += cursor.getString(2) + "\r\n";
                    count += 1;
                }
                // 다음 레코드값을 있으면 해당 필드값 변수저장

                edtNumberResult.setText(strNumbers);
                edtNameResult.setText(strNames);
                Toast.makeText(getApplicationContext(), count +"명이 있습니다.", Toast.LENGTH_SHORT).show();

                // 결과

                cursor.close();
                sqlDB.close();
            }
        });



    }

    public static class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context){
            super(context, "hmlee", null,1);
        }
        @Override
        public void onCreate(SQLiteDatabase db){
            // TODO Auto-generated method stub
            db.execSQL("CREATE TABLE student ( major TEXT, hackbun TEXT, name TEXT);");

            db.execSQL("INSERT INTO student" + " (major, hackbun, name)"
                    + " VALUES('com', '2018001', 'kildong');");
            db.execSQL("INSERT INTO student" + " (major, hackbun, name)"
                    + " VALUES('com', '2018002', 'ohjung');");
            db.execSQL("INSERT INTO student" + " (major, hackbun, name)"
                    + " VALUES('smart', '2018111', 'jungki');");
            db.execSQL("INSERT INTO student" + " (major, hackbun, name)"
                    + " VALUES('smart', '2018112', 'hanmin');");
            db.execSQL("INSERT INTO student" + " (major, hackbun, name)"
                    + " VALUES('com', '2018003', 'dongyeok');");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion){
            // TODO Auto-generated method stub
            db.execSQL("DROP TABLE IF EXISTS student");
            onCreate(db);
        }
    }

}
