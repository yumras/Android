package com.example.smart_16.project9_1_audio_1;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity1 extends AppCompatActivity{
    MediaPlayer mPlayer1, mPlayer2, mPlayer3;
    Button btn1, btn2, btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        setTitle("mp3 플레이어");
        mPlayer1 = MediaPlayer.create(MainActivity1.this, R.raw.song1);
        mPlayer1.setLooping(false);
        mPlayer2 = MediaPlayer.create(MainActivity1.this, R.raw.song2);
        mPlayer2.setLooping(false);
        mPlayer3 = MediaPlayer.create(MainActivity1.this, R.raw.song3);
        mPlayer3.setLooping(false);

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mPlayer1.isPlaying()){
                    mPlayer1.pause();
                }else{
                    mPlayer1.start();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mPlayer2.isPlaying()){
                    mPlayer2.pause();
                }else{
                    mPlayer2.start();
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mPlayer3.isPlaying()){
                    mPlayer3.pause();
                }else{
                    mPlayer3.start();
                }
            }
        });


    }
}
