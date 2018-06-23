package com.example.smart_16.project10_2_dbhelper_1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    EditText edtDiary;
    Button btnWrite;
    String fileName;
    File myDir;
    String strSDpath;

    myDBHelper myHelper;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("일정 관리");

        // id 찾기
        dp = (DatePicker)findViewById(R.id.datePicker1);
        edtDiary = (EditText)findViewById(R.id.edtDiary);
        btnWrite = (Button)findViewById(R.id.btnWrite);

        // 날짜 객체 선언 --> new Date 혹은 Calendar.getInstance() 클래스
        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR); // 시스템의 년도 값을 추출
        int cMonth = cal.get(Calendar.MONTH); // 시스템의 월 값을 추출 --> +1 해야 함
        int cDay = cal.get(Calendar.DAY_OF_MONTH); // 시스템의 일 값을 추출

        // 데이터베이스 초기화
        myHelper = new myDBHelper(this);
        sqlDB = myHelper.getWritableDatabase();
        myHelper.onUpgrade(sqlDB,1,2);
        sqlDB.close();

        // 처음의 실행한 날짜(오늘)를 체크하기
        fileName = Integer.toString(cYear) + "_" + Integer.toString(cMonth+1)
                + "_" + Integer.toString(cDay);
        String str = readDiary(fileName);
        edtDiary.setText(str);
        btnWrite.setEnabled(true);


        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                fileName = Integer.toString(year) + "_"
                        + Integer.toString(monthOfYear+1) + "_"
                        + Integer.toString(dayOfMonth);

                String str = readDiary(fileName);
                edtDiary.setText(str);
                btnWrite.setEnabled(true);
            }
        })  ;

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnWrite.getText().toString() == "새로저장"){
                    sqlDB = myHelper.getWritableDatabase();
                    sqlDB.execSQL("INSERT INTO myDiary VALUES ( '" + fileName
                        + "' ,'" + edtDiary.getText().toString() + "');");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(), "입력됨",
                            Toast.LENGTH_SHORT).show();
                } else {
                    sqlDB = myHelper.getWritableDatabase();
                    sqlDB.execSQL("UPDATE myDiary SET content = '"
                            + edtDiary.getText().toString()
                            + "' WHERE diaryDate = '" + fileName + "';");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(), "수정됨",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });


    }


    // readDiary 메서드 정의
    String readDiary(String fName) {
        String diaryStr = null;

        sqlDB = myHelper.getReadableDatabase();
        Cursor cursor;
        cursor = sqlDB.rawQuery("SELECT * FROM myDiary WHERE diaryDate ='"
                + fName + "';", null);

        if(cursor == null){
            edtDiary.setHint("일기없음");
            btnWrite.setText("새로저장");
        } else {
            if (cursor.moveToFirst() == true) {
                diaryStr = cursor.getString(1);
                btnWrite.setText("수정하기");
            } else {
                edtDiary.setHint("일기없음");
                btnWrite.setText("새로저장");
            }
        }

        cursor.close();
        sqlDB.close();

        return diaryStr;
    }

    // SQLiteOpenHelper
    public class myDBHelper extends SQLiteOpenHelper {
        // 생성자를 통해서 데이터베이스 만들기
        public myDBHelper(Context context){
            super(context, "myDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // 테이블 만들기
            db.execSQL("CREATE TABLE if not exists myDiary ( diaryDate CHAR(10) PRIMARY KEY, content VARCHAR(500));");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // 테이블 갱신 --> 테이블 삭제 후 새롭게 다시 생성
            db.execSQL("DROP TABLE if exists myDiary;");
            onCreate(db);
        }
    }

}
