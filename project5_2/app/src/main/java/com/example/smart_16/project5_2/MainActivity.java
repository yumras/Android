package com.example.smart_16.project5_2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ProgressBar mprogStatus;
    Button btnDecrease1, btnIncrease1;

    // Rating 추가
    Button btnDecrease2, btnIncrease2, btnResult;
    RatingBar mRatingVote;

    // Seekbar 추가
    SeekBar mSeekRed;
    View mViewColor1, mViewColor2, mViewColor3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Progress에 대한 id 찾기
        mprogStatus = (ProgressBar) findViewById(R.id.progStatus);
        btnDecrease1 = (Button) findViewById(R.id.btnDecrease1);
        btnIncrease1 = (Button) findViewById(R.id.btnIncrease1);

        // Rating에 대한 id 찾기
        mRatingVote = (RatingBar) findViewById(R.id.ratingVote);
        btnDecrease2 = (Button) findViewById(R.id.btnDecrease2);
        btnIncrease2 = (Button) findViewById(R.id.btnIncrease2);
        btnResult = (Button) findViewById(R.id.btnResult);

        // Seek에 대한 id 찾기
        mSeekRed = (SeekBar)findViewById(R.id.seekRed);
        mViewColor1 = (View)findViewById(R.id.viewColor1);
        mViewColor2 = (View)findViewById(R.id.viewColor2);
        mViewColor3 = (View)findViewById(R.id.viewColor3);

        // 기본배경 색상
        mSeekRed.setBackgroundColor(Color.argb( mSeekRed.getProgress(), 255, 255, 255));



        // Progress 감소 증가 하기 위한 버튼에 클릭
        btnDecrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mprogStatus.setProgress(mprogStatus.getProgress()-5);
            }
        });

        btnIncrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mprogStatus.setProgress(mprogStatus.getProgress()+5);
            }
        });

        // Rating 감소 증가 하기 위한 버튼에 클릭
        btnDecrease2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRatingVote.incrementProgressBy(-1);
            }
        });

        btnIncrease2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRatingVote.incrementProgressBy(1);
            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "현재값="+mRatingVote.getRating(), Toast.LENGTH_SHORT).show();
            }
        });

        // seekbar 이벤트
        mSeekRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mViewColor1.setBackgroundColor(Color.argb(255, progress, 0, 0));
                mViewColor2.setBackgroundColor(Color.argb(255, 0, -progress, 0));
                mViewColor3.setBackgroundColor(Color.argb(255, 0, 0, progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
