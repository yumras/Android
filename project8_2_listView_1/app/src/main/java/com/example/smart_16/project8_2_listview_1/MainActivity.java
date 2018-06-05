package com.example.smart_16.project8_2_listview_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트뷰 이용1");

        // 1> 리스트뷰에 나열될 내용을 string 배열로
        final String[] mid = { "히어로즈", "24시", "로스트", "로스트룸", "스몰빌", "탐정몽크",
            "빅뱅이론", "프렌즈", "덱스터", "글리", "가쉽걸", "테이큰", "슈퍼내추럴", "브이"};

        // 2> 리스트뷰 찾기
        ListView list = (ListView)findViewById(R.id.listView1);

        // 3> ArrayAdapter : 리스트뷰로 작성된 값과 배열 연결
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, mid);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        //      3-1) arrayadapter의 값을 보여줄 객체
        //      3-2) 모양
        //      3-3) 배열

        // 4> 리스트뷰에 array어댑터 연결
        list.setAdapter(adapter);

        // 5> 리스트뷰의 기능 연결
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), mid[position],
                        Toast.LENGTH_SHORT).show();
            }
        });


    }
}
