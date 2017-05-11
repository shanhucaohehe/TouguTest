package com.example.tie.mqttdemo.mqtt.model;


public class Subscription {



    private String topic;
    private int qos;
    private String lastMessage;
    private String clientHandle;

    public Subscription(String topic, int qos, String clientHandle, boolean enableNotifications){
        this.topic = topic;
        this.qos = qos;
        this.clientHandle = clientHandle;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getQos() {
        return qos;
    }

    public void setQos(int qos) {
        this.qos = qos;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getClientHandle() {
        return clientHandle;
    }

    public void setClientHandle(String clientHandle) {
        this.clientHandle = clientHandle;
    }


    @Override
    public String toString() {
        return "Subscription{" +
                "topic='" + topic + '\'' +
                ", qos=" + qos +
                ", clientHandle='" + clientHandle + '\'' +
                '}';
    }
}
