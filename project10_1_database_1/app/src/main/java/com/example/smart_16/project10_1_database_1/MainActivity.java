package com.example.smart_16.project10_1_database_1;

import android.content.Context;
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

    // 변수 선언
    myDBHelper myHelper; // DB 정보 가져옴
    EditText edtName, edtNumber, edtNameResult, edtNumberResult;
    Button btnInit, btnInsert, btnUpdate, btnDelete, btnSelect;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("가수 그룹 관리 DB(수정)");

        // id 찾기
        edtName = (EditText)findViewById(R.id.edtName);
        edtNumber = (EditText)findViewById(R.id.edtNumber);
        edtNameResult = (EditText)findViewById(R.id.edtNameResult);
        edtNumberResult = (EditText)findViewById(R.id.edtNumberResult);
        btnInit = (Button)findViewById(R.id.btnInit);
        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnSelect = (Button)findViewById(R.id.btnSelect);


        // DB 초기화
        myHelper = new myDBHelper(this);
        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                myHelper.onUpgrade(sqlDB,1,2);
                sqlDB.close();
            }
        });

        // insert 기능
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO groupTBL VALUES ( '"
                       + edtName.getText().toString() + "', "
                       + edtNumber.getText().toString() + ");");
                       // insert into groupTBL values('그룹명', 인원수);
                sqlDB.close();
                Toast.makeText(getApplicationContext(),"입력완료",Toast.LENGTH_SHORT).show();
           }
        });

        // update 기능
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                if (edtName.getText().toString() != ""){
                    sqlDB.execSQL("UPDATE groupTBL SET gNumber ="
                        + edtNumber.getText() + " WHERE gName = '"
                        + edtName.getText().toString() + "';");
                }
                sqlDB.close();
                Toast.makeText(getApplicationContext(),"수정완료",Toast.LENGTH_SHORT).show();
            }
        });

        // delete 기능
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                if (edtName.getText().toString() != ""){
                    sqlDB.execSQL("DELETE FROM groupTBL WHERE gName = '"
                        + edtName.getText().toString() + "';");
                }
                sqlDB.close();
                Toast.makeText(getApplicationContext(),"삭제완료",Toast.LENGTH_SHORT).show();
            }
        });

        // select 기능
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);

                String strNames ="그룹 이름" + "\r\n" + "___" + "\r\n";
                String strNumbers ="인원" + "\r\n" + "___" + "\r\n";

                while (cursor.moveToNext()){
                    strNames += cursor.getString(0) + "\r\n";
                    strNumbers += cursor.getString(1) + "\r\n";
                }
                // 다음 레코드값을 있으면 해당 필드값 변수저장

                edtNameResult.setText(strNames);
                edtNumberResult.setText(strNumbers);
                // 결과

                cursor.close();
                sqlDB.close();
            }
        });

    }

    public class myDBHelper extends SQLiteOpenHelper{
        public myDBHelper(Context context){
            super(context, "groupDB", null,1);
        }
        @Override
        public void onCreate(SQLiteDatabase db){
            // TODO Auto-generated method stub
            db.execSQL("CREATE TABLE groupTBL ( gName CHAR(20), gNumber INTEGER);");

        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                  int newVersion){
            // TODO Auto-generated method stub
            db.execSQL("DROP TABLE IF EXISTS groupTBL");
            onCreate(db);
        }
    }
}
