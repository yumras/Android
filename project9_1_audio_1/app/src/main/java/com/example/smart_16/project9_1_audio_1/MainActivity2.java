package com.example.smart_16.project9_1_audio_1;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity{
    MediaPlayer do_l, re, mi, fa, sol, ra, si, do_h;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("실로폰");
        do_l = MediaPlayer.create(MainActivity2.this, R.raw.do_l);
        do_l.setLooping(true);
        re = MediaPlayer.create(MainActivity2.this, R.raw.re);
        re.setLooping(true);
        mi = MediaPlayer.create(MainActivity2.this, R.raw.mi);
        mi.setLooping(true);
        fa = MediaPlayer.create(MainActivity2.this, R.raw.fa);
        fa.setLooping(true);
        sol = MediaPlayer.create(MainActivity2.this, R.raw.sol);
        sol.setLooping(true);
        ra = MediaPlayer.create(MainActivity2.this, R.raw.ra);
        ra.setLooping(true);
        si = MediaPlayer.create(MainActivity2.this, R.raw.si);
        si.setLooping(true);
        do_h = MediaPlayer.create(MainActivity2.this, R.raw.do_h);
        do_h.setLooping(true);

        btn1 = (Button)findViewById(R.id.do_l);
        btn2 = (Button)findViewById(R.id.re);
        btn3 = (Button)findViewById(R.id.mi);
        btn4 = (Button)findViewById(R.id.fa);
        btn5 = (Button)findViewById(R.id.sol);
        btn6 = (Button)findViewById(R.id.ra);
        btn7 = (Button)findViewById(R.id.si);
        btn8 = (Button)findViewById(R.id.do_h);
        btn9 = (Button)findViewById(R.id.Chord_I);
        btn10 = (Button)findViewById(R.id.Chord_IV);
        btn11 = (Button)findViewById(R.id.Chord_V);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(do_l.isPlaying()){
                    do_l.pause();
                }else{
                    do_l.start();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(re.isPlaying()){
                    re.pause();
                }else{
                    re.start();
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mi.isPlaying()){
                    mi.pause();
                }else{
                    mi.start();
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fa.isPlaying()){
                    fa.pause();
                }else{
                    fa.start();
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sol.isPlaying()){
                    sol.pause();
                }else{
                    sol.start();
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ra.isPlaying()){
                    ra.pause();
                }else{
                    ra.start();
                }
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(si.isPlaying()){
                    si.pause();
                }else{
                    si.start();
                }
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(do_h.isPlaying()){
                    do_h.pause();
                }else{
                    do_h.start();
                }
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(do_l.isPlaying()){
                    do_l.pause();
                    mi.pause();
                    sol.pause();
                }else{
                    do_l.start();
                    mi.start();
                    sol.start();
                }
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fa.isPlaying()){
                    fa.pause();
                    ra.pause();
                    do_h.pause();
                }else{
                    fa.start();
                    ra.start();
                    do_h.start();
                }
            }
        });

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(si.isPlaying()){
                    si.pause();
                    sol.pause();
                    re.pause();
                }else{
                    si.start();
                    sol.start();
                    re.start();
                }
            }
        });



    }
}
