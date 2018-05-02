package com.example.test.entity;

import java.util.Date;

import cn.bmob.v3.BmobObject;

public class QueAndExc extends BmobObject {

    private String headImg;
    private String name;
    private String selfAddr;
    private Date queDate;
    private String article;
    private String bodyImg;
    private String bodyAddr;
    private String like;
    private String comment;

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSelfAddr() {
        return selfAddr;
    }

    public void setSelfAdress(String selfAddr) {
        this.selfAddr = selfAddr;
    }

    public Date getQueDate() {
        return queDate;
    }

    public void setQueDate(Date queDate) {
        this.queDate = queDate;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getBodyImg() {
        return bodyImg;
    }

    public void setBodyImg(String bodyImg) {
        this.bodyImg = bodyImg;
    }

    public String getBodyAddr() {
        return bodyAddr;
    }

    public void setBodyAddr(String bodyIng) {
        this.bodyAddr= bodyIng;
    }

    public void setSelfAddr(String selfAddr) {
        this.selfAddr = selfAddr;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
