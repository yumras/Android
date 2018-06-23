package com.example.smart_16.exam1_1820340066;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by SMART-16 on 2018-06-22.
 */

public class StudentItemView extends LinearLayout{
    TextView textView2;
    ImageView imageView;

    public StudentItemView(Context context){
        super(context);

        init(context);
    }

    public StudentItemView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);

        init(context);
    }

    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.student_item, this, true);

        textView2 = (TextView)findViewById(R.id.textView2);
        imageView = (ImageView)findViewById(R.id.imageView);
    }


    public void setName(String name) {
        textView2.setText(name);
    }

    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }
}
