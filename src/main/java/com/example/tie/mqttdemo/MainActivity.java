package com.example.tie.mqttdemo;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private HistoryAdapter mAdapter;

    MqttAndroidClient mqttAndroidClient;

    //    final String serverUri = "tcp://172.18.14.213:1883";
    final String serverUri = "tcp://101.37.33.136:1883";

    String clientId = "android";
    final String subscriptionTopic = "testtopic";
//    final String publishTopic = "testtopic";
//    final String publishMessage = "Hello World!";

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String obj = (String) msg.obj;
            addToHistory(obj);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String SAVE_PIC_PATH = Environment
                .getExternalStorageState().equalsIgnoreCase(
                        Environment.MEDIA_MOUNTED) ? Environment
                .getExternalStorageDirectory().getAbsolutePath() : "/mnt/sdcard";
        String str = "";
        for (int i = 0; i < 50; i++) {
            str += "qidian" + (i + 1) + ",qidian" + (i + 1) + "\n";
        }

        try {
            File file = new File(SAVE_PIC_PATH,
                    "ag.txt");
            //第二个参数意义是说是否以append方式添加内容
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            String info = str;
            bw.write(info);
            bw.flush();
            System.out.println("写入成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                publishMessage();
//            }
//        });


        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.history_recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new HistoryAdapter(new ArrayList<String>());
        mRecyclerView.setAdapter(mAdapter);

        clientId = clientId + System.currentTimeMillis();

        mqttAndroidClient = new MqttAndroidClient(getApplicationContext(), serverUri, clientId);
        mqttAndroidClient.setCallback(new MqttCallbackExtended() {
            @Override
            public void connectComplete(boolean reconnect, String serverURI) {

                if (reconnect) {
                    addToHistory("Reconnected to : " + serverURI);
                    // Because Clean Session is true, we need to re-subscribe
                    subscribeToTopic();
                } else {
                    addToHistory("Connected to: " + serverURI);
                }
            }

            @Override
            public void connectionLost(Throwable cause) {
                addToHistory("The Connection was lost." + cause.getMessage());
            }

            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                addToHistory("Incoming message: " + new String(message.getPayload()));
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {

            }
        });

        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setAutomaticReconnect(true);
        mqttConnectOptions.setCleanSession(false);
        mqttConnectOptions.setUserName("admin");
        mqttConnectOptions.setPassword("admin".toCharArray());


        try {
            //addToHistory("Connecting to " + serverUri);
            mqttAndroidClient.connect(mqttConnectOptions, null, new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    DisconnectedBufferOptions disconnectedBufferOptions = new DisconnectedBufferOptions();
                    disconnectedBufferOptions.setBufferEnabled(true);
                    disconnectedBufferOptions.setBufferSize(100);
                    disconnectedBufferOptions.setPersistBuffer(false);
                    disconnectedBufferOptions.setDeleteOldestMessages(false);
                    mqttAndroidClient.setBufferOpts(disconnectedBufferOptions);
                    subscribeToTopic();
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    addToHistory("Failed to connect to: " + serverUri);
                }
            });


        } catch (MqttException ex) {
            ex.printStackTrace();
        }

        //startActivity(new Intent(this,KlineActivity.class));

    }

    private void addToHistory(String mainText) {
        // System.out.println("LOG: " + mainText);
        mAdapter.add(mainText);
//        Snackbar.make(findViewById(android.R.id.content), mainText, Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    public void subscribeToTopic() {
        try {
//            mqttAndroidClient.subscribe(subscriptionTopic, 0, null, new IMqttActionListener() {
//                @Override
//                public void onSuccess(IMqttToken asyncActionToken) {
//                    addToHistory("Subscribed!");
//                }
//
//                @Override
//                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
//                    addToHistory("Failed to subscribe");
//                }
//            });

            // THIS DOES NOT WORK!
            mqttAndroidClient.subscribe(subscriptionTopic, 0, new IMqttMessageListener() {
                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    // message Arrived!
                    //System.out.println("Message: " + topic + " : " + new String(message.getPayload()));
                    Message message1 = new Message();
                    message1.obj = new String(message.getPayload());
                    mHandler.sendMessage(message1);

                    //EventBus.getDefault().post();
                }
            });

        } catch (MqttException ex) {
            System.err.println("Exception whilst subscribing");
            ex.printStackTrace();
        }
    }

//    public void publishMessage(){
//
//        try {
//            MqttMessage message = new MqttMessage();
//            message.setPayload(publishMessage.getBytes());
//            mqttAndroidClient.publish(publishTopic, message);
//            addToHistory("Message Published");
//            if(!mqttAndroidClient.isConnected()){
//                addToHistory(mqttAndroidClient.getBufferedMessageCount() + " messages in buffer.");
//            }
//        } catch (MqttException e) {
//            System.err.println("Error Publishing: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
}
