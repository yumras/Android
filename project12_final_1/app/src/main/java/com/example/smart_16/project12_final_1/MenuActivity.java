package com.example.smart_16.project12_final_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity{
    TextView textView;
    Button customerButton, productButton, salesButton, backButton;
    Intent intent;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textView = (TextView)findViewById(R.id.textView);

        customerButton = (Button)findViewById(R.id.customerButton);
        customerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), CustomerActivity.class);
                startActivity(intent);
            }
        });

        productButton = (Button)findViewById(R.id.productButton);
        productButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), ProductActivity.class);
                startActivity(intent);
            }
        });

        salesButton = (Button)findViewById(R.id.salesButton);
        salesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), RevenueActivity.class);
                startActivity(intent);
            }
        });


        backButton = (Button)findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("type", "감사합니다");

                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });

        Toast.makeText(this, "비밀번호 : " + AppData.password, Toast.LENGTH_SHORT).show();

        intent = getIntent();
        processCommand(intent);
    }

    public void processCommand(Intent intent){
        if(intent != null){
            String id = intent.getStringExtra("id");
            textView.setText(id+ "님 환영합니다.");
        }
    }


}
