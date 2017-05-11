package com.example.tie.mqttdemo;

/**
 * Created by tie on 2017/4/11.
 */

public class Topic {


    /**
     * bourse : HG
     * goodsType : HGAG
     */

    private String bourse;
    private String goodsType;

    public String getBourse() {
        return bourse;
    }

    public void setBourse(String bourse) {
        this.bourse = bourse;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "bourse='" + bourse + '\'' +
                ", goodsType='" + goodsType + '\'' +
                '}';
    }
}
