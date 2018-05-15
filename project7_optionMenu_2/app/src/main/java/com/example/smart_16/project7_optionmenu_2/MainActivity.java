package com.example.smart_16.project7_optionmenu_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    EditText edtAngle;
    ImageView imageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("제주도 풍경");
        edtAngle=(EditText)findViewById(R.id.edtAngle);
        imageView1=(ImageView)findViewById(R.id.imageView1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemRotate:
                imageView1.setRotation(Float.parseFloat(edtAngle.getText().toString()));
                return true;
            case R.id.itme1:
                imageView1.setImageResource(R.drawable.baekdo);
                return true;
            case R.id.itme2:
                imageView1.setImageResource(R.drawable.jeju);
                return true;
            case R.id.itme3:
                imageView1.setImageResource(R.drawable.gwanghwa);
                return true;
        }
        return false;
    }
}
