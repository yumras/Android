package com.example.smart_16.lunchmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    WebView web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web = (WebView)findViewById(R.id.webView1);
        web.loadUrl("http://www.kopo.ac.kr/kangseo/content.do?menu=262#");


    }
}
