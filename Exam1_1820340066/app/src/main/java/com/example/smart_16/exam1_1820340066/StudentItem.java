package com.example.smart_16.exam1_1820340066;

/**
 * Created by SMART-16 on 2018-06-22.
 */

public class StudentItem {
    private String name;
    private int restID;

    public StudentItem(String name){
        this.name = name;
    }

    public StudentItem(String name, int restID){
        this.name = name;
        this.restID = restID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRestID() {
        return restID;
    }

    public void setRestID(int restID) {
        this.restID = restID;
    }

    public String toString(){
        String result = "이름: "+name;
        result += ", 이미지: "+restID;

        return result;
    }
}
