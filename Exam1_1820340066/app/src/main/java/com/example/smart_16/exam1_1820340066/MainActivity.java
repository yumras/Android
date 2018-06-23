package com.example.smart_16.exam1_1820340066;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    StudentAdapter adapter;
    EditText dlgEdtName;
    TextView textView;
    View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("학생목록 관리");


        listView = (ListView)findViewById(R.id.ListView);
        textView = (TextView)findViewById(R.id.textView);

        adapter = new StudentAdapter();
        adapter.addItem(new StudentItem("고양이", R.drawable.cat));
        adapter.addItem(new StudentItem("강아지", R.drawable.dog));
        adapter.addItem(new StudentItem("토끼", R.drawable.rabbit));
        adapter.addItem(new StudentItem("코알라", R.drawable.koala));
        adapter.addItem(new StudentItem("펭귄", R.drawable.penguin));

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StudentItem item = (StudentItem)adapter.getItem(position);
                Toast.makeText(getApplicationContext(),
                        item.getName()+"번째 항목입니다.", Toast.LENGTH_LONG).show();
            }
        });
    }

    class  StudentAdapter extends BaseAdapter {
        ArrayList<StudentItem> items = new ArrayList<StudentItem>();

        @Override
        public int getCount() {
            return items.size();
        }
        // 추가 메서드
        public  void addItem(StudentItem item){
            items.add(item); // ArrayList에서 추가 add, remove(제거), size(크기), get(값알아보기)
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            StudentItemView view = new StudentItemView(getApplicationContext());

            StudentItem item = items.get(position);
            view.setName(item.getName());
            view.setImage(item.getRestID());

            return view;
        }


    }


    // onCreateOptionsMenu ==> xml을 이용한 메뉴 구성
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    // 메뉴 항목에 기능 부여
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case  R.id.itemLogIn:
                dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("사용자 정보 입력");
                dlg.setView(dialogView);

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dlgEdtName = (EditText)dialogView.findViewById(R.id.dlgEdt1);
                        textView.setText(dlgEdtName.getText().toString());

                    }
                });
                dlg.show();
                return true;
            case R.id.itemShow:
                Toast.makeText(getApplicationContext(),"2018.6.22(제작:이한민)", Toast.LENGTH_LONG).show();
                return true;

        }
        return false;
    }


}
