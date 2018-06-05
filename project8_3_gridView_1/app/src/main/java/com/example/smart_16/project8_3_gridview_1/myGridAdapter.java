package com.example.smart_16.project8_3_gridview_1;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class myGridAdapter extends BaseAdapter {
    // 변수 선언
    Context context;
    // 배열 선언
    Integer[] posterID = {
            R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,R.drawable.mov05,
            R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,R.drawable.mov10,
            R.drawable.mov11,R.drawable.mov12,R.drawable.mov13,R.drawable.mov14,R.drawable.mov15,
            R.drawable.mov16,R.drawable.mov17,R.drawable.mov18,R.drawable.mov19,R.drawable.mov20,
            R.drawable.mov21,R.drawable.mov22,R.drawable.mov23,R.drawable.mov24,R.drawable.mov25,
            R.drawable.mov26,R.drawable.mov27,R.drawable.mov28,R.drawable.mov29,R.drawable.mov30,
            R.drawable.mov31,R.drawable.mov32,R.drawable.mov33,R.drawable.mov34,R.drawable.mov35,
            R.drawable.mov36,R.drawable.mov37,R.drawable.mov38,R.drawable.mov39,R.drawable.mov40,
            R.drawable.mov41,R.drawable.mov42,R.drawable.mov43,R.drawable.mov44,R.drawable.mov45,
            R.drawable.mov46,R.drawable.mov47,R.drawable.mov48,R.drawable.mov49,R.drawable.mov50,
            R.drawable.mov51,R.drawable.mov52,R.drawable.mov53,R.drawable.mov54,R.drawable.mov55,
            R.drawable.mov56,R.drawable.mov57,R.drawable.mov58,R.drawable.mov59,R.drawable.mov60,
            R.drawable.mov61
    };

    // context가 있는 생성자
    public myGridAdapter(Context c) {
        this.context = c;
    }
    @Override
    public int getCount(){
        return posterID.length;
    }
    @Override
    public Object getItem(int position){
        return null;
    }

    @Override
    public long getItemId(int position){
        return 0;
    }
    String[] posterTitle = {"써니", "완득이", "괴물", "라디오스타", "비열한거리", "왕의남자",
            "아일랜드", "웰컴투동막골", "헬보이", "백투터퓨처", "여인의향기", "쥬라기공원",
            "포레스트검프", "사랑의블랙홀", "혹성탈출", "아름다운비행", "내이름은칸",
            "해리포터", "마더", "킹콩을들다", "쿵푸팬더2", "짱구는못말려", "아저씨",
            "아바타", "대부", "국가대표", "토이스토리3", "마당을나온암탉", "죽은시인의사회",
            "서유쌍기", "킹콩", "반지의제왕", "8월의크리스마스", "미녀는괴로워", "나홀로집에",
            "파이란", "더록", "로마의휴일", "매트릭스", "가위손", "양들의침묵", "AI", "집으로",
            "글래디에이터", "쇼생크탈출", "인생은아름다워", "피아니스트", "사운드오브뮤직",
            "ET", "나비효과", "레옹", "바람과함께사라지다", "아마데우스", "라스트모히칸",
            "센과치히로의행방불명", "에일리언", "터미네이터2", "테이큰", "브레이브하트",
            "시네마천국", "월-E"};

    @Override
    public View getView(int position, View convertView, ViewGroup paretn){

        // 1> 이미지 뷰를 생성한 후 값 직접 보여줌
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new GridView.LayoutParams(200,300));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(5,5,5,5);
        imageView.setImageResource(posterID[position]);

        // 2> 기능 부여
        final int pos = position;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity a = new MainActivity();
                View dialogView = (View) View.inflate(context,
                        R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                ImageView ivPoster = (ImageView)dialogView.findViewById(R.id.ivPoster);
                ivPoster.setImageResource(posterID[pos]);
                dlg.setTitle(posterTitle[pos]);
                dlg.setIcon(R.drawable.movie_icon);
                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }
        });

        // 3> 결과값 리턴
        return  imageView;
    }
}
