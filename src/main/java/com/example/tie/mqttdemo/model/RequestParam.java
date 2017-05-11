package com.example.tie.mqttdemo.model;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * 请求参数封装
 * Created by tie on 2017/4/18.
 */

public class RequestParam {

    private Map<String, Object> mMap = new HashMap<>();
    private Map<String, String> mParamMap = new HashMap<>();

    public RequestParam(String type) {
        mMap.put("Type", type);
        mMap.put("Param", mParamMap);
    }

    /**
     * 添加Param中的键值对
     * @param key
     * @param value
     */
    public void put(String key, String value) {
        mParamMap.put(key, value);
    }

    public String getResult() {

        String json = new Gson().toJson(mMap);

        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><soapenv:Body><trade xmlns=\"urn:trade\"><request xmlns=\"\">"+ json +"</request></trade></soapenv:Body></soapenv:Envelope>\n" +
                "\n";
        return str;
    }

    public String getKlineResult() {

        String json = new Gson().toJson(mMap);

        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><soapenv:Body><quote xmlns=\"urn:quote\"><request xmlns=\"\">"+ json +"</request></quote></soapenv:Body></soapenv:Envelope>\n" +
                "\n";
        return str;
    }
}
