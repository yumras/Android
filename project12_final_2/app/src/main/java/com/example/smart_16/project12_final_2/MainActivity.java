package com.example.smart_16.project12_final_2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    SingerAdapter adapter;
    EditText editText, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.ListView);

        adapter = new SingerAdapter();
        adapter.addItem(new SingerItem("고양이","010-000-0000", R.drawable.cat));
        adapter.addItem(new SingerItem("강아지","010-111-1111", R.drawable.dog));
        adapter.addItem(new SingerItem("토끼","010-222-2222", R.drawable.rabbit));
        adapter.addItem(new SingerItem("말","010-333-3333", R.drawable.horse));
        adapter.addItem(new SingerItem("코알라","010-444-4444", R.drawable.koala));
        adapter.addItem(new SingerItem("펭귄","010-555-5555", R.drawable.penguin));

        listView.setAdapter(adapter);

        // ListItem을 클릭할 때 마다 토스트 출력
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerItem item = (SingerItem)adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"선택: "+item.getName(), Toast.LENGTH_LONG).show();
            }
        });

        // 추가 버튼 눌렀을 때 추가 되는 값...
        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                String mobile = editText2.getText().toString();

                SingerItem item = new SingerItem(name, mobile, R.drawable.ic_launcher_foreground);
                adapter.addItem(item);
                adapter.notifyDataSetChanged();

            }
        });

    }


    class  SingerAdapter extends BaseAdapter{
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        @Override
        public int getCount() {
            return items.size();
        }
        // 추가 메서드
        public  void addItem(SingerItem item){
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
            SingerItemView view = new SingerItemView(getApplicationContext());

            SingerItem item = items.get(position);
            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setImage(item.getRestID());

            return view;
        }

        // 리스트는 수업시간에 한 실습으로 --> 모바일_12(sli.38)
    }

}
