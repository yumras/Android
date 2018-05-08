package com.example.smart_16.midtermprac2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView img1, img2, img3, img4;
    TextView art1, art2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1=(ImageView)findViewById(R.id.img1);
        img2=(ImageView)findViewById(R.id.img2);
        img3=(ImageView)findViewById(R.id.img3);
        img4=(ImageView)findViewById(R.id.img4);
        art1=(TextView)findViewById(R.id.artist01);
        art2=(TextView)findViewById(R.id.artist02);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img3.setVisibility(view.VISIBLE);
                img4.setVisibility(view.INVISIBLE);
                Toast.makeText(getApplicationContext(),art1.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img4.setVisibility(view.VISIBLE);
                img3.setVisibility(view.INVISIBLE);
                Toast.makeText(getApplicationContext(),art2.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
