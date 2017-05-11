package com.example.tie.mqttdemo.utils;

/**
 * 网络访问回调
 * Created by tie on 2017/2/16.
 */

public interface Callback {

    public void onResponse(String response);

    public void onErrorResponse(String message);
}
