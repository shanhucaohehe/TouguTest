package com.example.tie.mqttdemo;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.StringReader;

/**
 * Created by tie on 2017/4/18.
 */

public class PullPersonService {

    /**
     * ------------------------使用PULL解析XML-----------------------
     * @param str
     * @return
     * @throws Exception
     */
    public static String getResponse(String str)
            throws Exception {
        //Person person = null;
        //List<Person> persons = null;
        XmlPullParser pullParser = Xml.newPullParser();
        String response = "";
        pullParser.setInput(new StringReader(str));
        int event = pullParser.getEventType();// 觸發第一個事件
        while (event != XmlPullParser.END_DOCUMENT) {
            switch (event) {
                case XmlPullParser.START_TAG:
                    if ("result".equals(pullParser.getName())) {
                        response = pullParser.nextText();
                        return response;
                    }
            }
            event = pullParser.next();
        }
      return response;
    }
}
