package com.example.myapplication.EventBus;

/*
 * @Author: Luke
 * @Date: 2019-07-19 12:07
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Android_Study_Project_demo
 */
public class MessageWrap {
    public final String message;

    public static MessageWrap getInstance(String message){
        return new MessageWrap(message);
    }

    public MessageWrap(String message) {
        this.message = message;
    }
}
