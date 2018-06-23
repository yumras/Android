package com.example.smart_16.project9_1_audio_2;

import android.Manifest;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewMP3;
    Button btnPlay, btnStop;
    TextView tvMP3;
    ProgressBar pbMP3;

    ArrayList<String> mp3List; // 배열 --> ArrayAdapter 연결
    String selectedMP3;

    String mp3Path = Environment.getExternalStorageDirectory().getPath() + "/Music/";
    MediaPlayer mPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 MP3 플레이어");
        // 외부 저장 장치 접근 권한 --> androidManifest.xml에서 
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_APPEND);
        mp3List = new ArrayList<String>();

        // File 클래스 다루기

        File[] listFiles = new File(mp3Path).listFiles();
        // listFiles() : 해당 경로 폴더 안에 있는 모든 파일을 컬렉션 타입으로
        String fileName, extName; // 파일이름, 확장자 저장 변수
        for (File file : listFiles){
            fileName = file.getName(); // getName() : 파일 이름
            extName = fileName.substring(fileName.length()-3); // 시작위치부터 끝까지 추출
            if (extName.equals((String)"mp3"))
                mp3List.add(fileName); //ArrayList에 추가
        };

        listViewMP3 = (ListView)findViewById(R.id.listViewMP3);
        ArrayAdapter<String> adpter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice, mp3List);

        listViewMP3.setChoiceMode(ListView.CHOICE_MODE_SINGLE); // 라디오 버튼 모양
        listViewMP3.setAdapter(adpter); // 리스트뷰와 arrayadapter 연결
        listViewMP3.setItemChecked(0, true); // 첫번째값 디폴트

        listViewMP3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        selectedMP3 = mp3List.get(position);
                    }
        });
        selectedMP3 = mp3List.get(0); //첫번째 노래로 디폴트

        // 재생, 정지 기능
        btnPlay = (Button)findViewById(R.id.btnPlay);
        btnStop = (Button)findViewById(R.id.btnStop);
        tvMP3 = (TextView)findViewById(R.id.tvMP3);
        pbMP3 = (ProgressBar)findViewById(R.id.pbMP3);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mPlayer = new MediaPlayer();
                    mPlayer.setDataSource(mp3Path + selectedMP3);
                    mPlayer.prepare();
                    mPlayer.start();
                    btnPlay.setClickable(false); //비활성화
                    btnStop.setClickable(true); //활성화
                    tvMP3.setText("실행중인 음악 : "+selectedMP3);
                    pbMP3.setVisibility(View.VISIBLE);
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.stop();
                mPlayer.reset();
                btnPlay.setClickable(true); //활성화
                btnStop.setClickable(false); //비활성화
                tvMP3.setText("실행중인 음악 :   ");
                pbMP3.setVisibility(View.INVISIBLE);
            }
        });
        btnStop.setClickable(false);

    }
}
