package com.example.tie.mqttdemo.mqtt.internal;
import com.example.tie.mqttdemo.mqtt.model.ReceivedMessage;

public interface IReceivedMessageListener {

    void onMessageReceived(ReceivedMessage message);
}