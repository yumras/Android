package com.example.smart_16.project6_intent_5;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnDial, btnWeb, btnGoogleMap, btnSearch, btnSms;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("암시적 인텐트 예제");

        // id 찾기
        btnDial = (Button)findViewById(R.id.btnDial);
        btnWeb = (Button)findViewById(R.id.btnWeb);
        btnGoogleMap = (Button)findViewById(R.id.btnGoogleMap);
        btnSearch = (Button)findViewById(R.id.btnSearch);
        btnSms = (Button)findViewById(R.id.btnSms);

        // 전화걸기
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uri = Uri.parse("tel:01012345678");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

        // 홈페이지 보기
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uri = Uri.parse("http://www.kopo.ac.kr/kangseo/content.do?menu=262");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //구글 지도
        btnGoogleMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uri = Uri.parse("http://maps.google.com/maps?q="+37.549700+","+126.840887);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        // 구글 검색하기
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "강서폴리텍 스마트금융");
                startActivity(intent);
            }
        });

        // 문자 보내기
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body", "안녕");
                uri = Uri.parse("smsto:" + uri.encode("010-0000-0000"));
                intent.setData(uri);
                startActivity(intent);
            }
        });





    }
}
