package com.example.smart_16.project6_intent_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by SMART-16 on 2018-05-04.
 */

public class ThirdActivity extends AppCompatActivity {

    Button btnReturn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);

        btnReturn = (Button)findViewById(R.id.btnReturn1);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
