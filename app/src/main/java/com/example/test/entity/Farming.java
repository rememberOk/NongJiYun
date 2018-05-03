package com.example.test.entity;

public class Farming {

    private String img;
    private String title;
    private String body;
    private String date;
    private String readNum;

    public Farming(String img, String title, String body, String date, String readNum) {
        this.img = img;
        this.title = title;
        this.body = body;
        this.date = date;
        this.readNum = readNum;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReadNum() {
        return readNum;
    }

    public void setReadNum(String readNum) {
        this.readNum = readNum;
    }
}
