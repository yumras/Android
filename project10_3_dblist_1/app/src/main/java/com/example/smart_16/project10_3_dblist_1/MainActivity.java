package com.example.smart_16.project10_3_dblist_1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DB_Open db_open;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> arr = new ArrayList<String>();

        db_open = new DB_Open(this);
        db = db_open.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT user_name FROM db_user", null);
        c.moveToFirst();
        c.getCount();

        // 순서대로 ArrayList에 뿌림
        for (int i = 0; i < c.getCount(); i++) {
            arr.add(c.getString(0));
            c.moveToNext();
        }
        ListView list = (ListView)findViewById(R.id.list1);
        final ArrayAdapter<String> aaa =new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arr);
        list.setAdapter(aaa);
    }

    public class DB_Open extends SQLiteOpenHelper {

        public DB_Open(Context context){
            super(context, "db_user", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE db_user" + "(_user_id text primary key,"
                    + "user_id TEXT, user_name TEXT, user_number INTEGER);");

            db.execSQL("INSERT INTO db_user" + " (user_id, user_name, user_number)"
                    + " VALUES('yang', '양현종', 100);");
            db.execSQL("INSERT INTO db_user" + " (user_id, user_name, user_number)"
                    + " VALUES('lee', '이명기', 101);");
            db.execSQL("INSERT INTO db_user" + " (user_id, user_name, user_number)"
                    + " VALUES('roger', '버나디나', 102);");
            db.execSQL("INSERT INTO db_user" + " (user_id, user_name, user_number)"
                    + " VALUES('kim', '김주찬', 103);");
            db.execSQL("INSERT INTO db_user" + " (user_id, user_name, user_number)"
                    + " VALUES('choi', '최형우', 104);");
            db.execSQL("INSERT INTO db_user" + " (user_id, user_name, user_number)"
                    + " VALUES('an', '안치홍', 105);");
            db.execSQL("INSERT INTO db_user" + " (user_id, user_name, user_number)"
                    + " VALUES('na', '나지완', 106);");
            db.execSQL("INSERT INTO db_user" + " (user_id, user_name, user_number)"
                    + " VALUES('leeBH', '꽃범호', 107);");
            db.execSQL("INSERT INTO db_user" + " (user_id, user_name, user_number)"
                    + " VALUES('kimMS', '김민식', 108);");
            db.execSQL("INSERT INTO db_user" + " (user_id, user_name, user_number)"
                    + " VALUES('kimSB', '김선빈', 109);");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // 기존 테이블 삭제
            db.execSQL("DROP TABLE IF EXISTS db_user;");
            // 새로 DB 생성
            onCreate(db);
        }
    }



}
