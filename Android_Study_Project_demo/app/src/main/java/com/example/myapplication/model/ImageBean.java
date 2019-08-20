package com.example.myapplication.model;

import com.stx.xhb.androidx.entity.SimpleBannerInfo;

/*
 * @Author: Luke
 * @Date: 2019-08-20 16:05
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Android_Study_Project_demo
 */
public class ImageBean extends SimpleBannerInfo {

    String id;
    String time;
    String imgUrl;

    public ImageBean(String id, String time, String imgUrl) {
        this.id = id;
        this.time = time;
        this.imgUrl = imgUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String getXBannerUrl() {
        return imgUrl;
    }
}
