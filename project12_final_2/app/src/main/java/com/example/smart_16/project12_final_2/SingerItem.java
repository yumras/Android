package com.example.smart_16.project12_final_2;


public class SingerItem {
    private String name;
    private String mobile;
    private int restID; // Drawable img
    //생성자
    public SingerItem(String name, String mobile){
        this.name=name;
        this.mobile=mobile;
    }

    public SingerItem(String name, String mobile, int restID){
        this.name=name;
        this.mobile=mobile;
        this.restID=restID;
    }

    // getter/setter 추가


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getRestID() {
        return restID;
    }

    public void setRestID(int restID) {
        this.restID = restID;
    }

    // 객체결과 메서지
    public String toString() {
        String result = "이름: " + name;
        result += ", 전화번호: " + mobile;
        result += ", 이미지: " + restID;

        return result;
    }
}
