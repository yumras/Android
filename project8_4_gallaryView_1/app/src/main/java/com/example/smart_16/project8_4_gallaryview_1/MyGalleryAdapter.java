package com.example.smart_16.project8_4_gallaryview_1;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MyGalleryAdapter extends BaseAdapter {
    Context context;
    Integer [] posterID={R.drawable.mov52, R.drawable.mov53, R.drawable.mov54,
            R.drawable.mov55, R.drawable.mov56, R.drawable.mov57, R.drawable.mov58,
            R.drawable.mov59, R.drawable.mov60, R.drawable.mov61};

    // 생성자
    public MyGalleryAdapter(Context c){
        context=c;
    }

    @Override
    public int getCount() {
        return posterID.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new Gallery.LayoutParams(200,300));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(5,5,5,5);
        imageView.setImageResource(posterID[position]);

        // 기능 부여
        final int pos = position;
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ImageView ivposter = (ImageView)((MainActivity)context).findViewById(R.id.ivPoster);
                ivposter.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ivposter.setImageResource(posterID[pos]);

                return false;
            }
        });
        return imageView;
    }
}
