package com.example.myapplication.model;

import java.util.List;

/*
 * @Author: Luke
 * @Date: 2019-08-20 16:07
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Android_Study_Project_demo
 */
public class ImageEntity {

    private String code;
    private String message;
    private List<ImageBean> imageBeanList;

    public ImageEntity(String code, String message, List<ImageBean> imageBeanList) {
        this.code = code;
        this.message = message;
        this.imageBeanList = imageBeanList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ImageBean> getImageBeanList() {
        return imageBeanList;
    }

    public void setImageBeanList(List<ImageBean> imageBeanList) {
        this.imageBeanList = imageBeanList;
    }



}
