package com.example.smart_16.project7_2_contextmenu_1_xml;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;
    LinearLayout baseLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("컨텍스트 메뉴");
        btn1 = (Button)findViewById(R.id.btn1);
        registerForContextMenu(btn1); // 컨텍스트 메뉴를 나오게 할 대상
        btn2 = (Button)findViewById(R.id.btn2);
        registerForContextMenu(btn2);
        baseLayout = (LinearLayout)findViewById(R.id.baseLayout);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu,
                View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater mInflater = getMenuInflater();
        if(v == btn1) {
            mInflater.inflate(R.menu.menu1, menu);
        }
        if(v == btn2) {
            mInflater.inflate(R.menu.menu2, menu);
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.itemRed :
                baseLayout.setBackgroundColor(Color.RED);
                return true;

            case R.id.itemGreen :
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;

            case R.id.itemBlue :
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;

            case R.id.itemBack :
                baseLayout.setBackgroundColor(Color.WHITE);
                return true;

            case R.id.subRotate :
                baseLayout.setRotation(45);
                return true;

            case R.id.subSize :
                baseLayout.setScaleX(2);
                return true;

            case R.id.subBack :
                baseLayout.setRotation(0);
                baseLayout.setScaleX(1);
                return true;
        }
    return false;


    }

}
