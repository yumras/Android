package com.example.smart_16.project8_2_listview_4.ListVO;


import android.graphics.drawable.Drawable;

public class ListVO {
    // 리스트에 들어갈 데이터 목록 관리하기 위한 클래스
    private Drawable img;
    private String Title;
    private String context;

    // getter / setter 메서드


    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }


}
