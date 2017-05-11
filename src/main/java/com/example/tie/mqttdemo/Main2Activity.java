package com.example.tie.mqttdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tie.mqttdemo.mqtt.internal.Connection;
import com.example.tie.mqttdemo.mqtt.internal.Connections;
import com.example.tie.mqttdemo.utils.Constants;

public class Main2Activity extends AppCompatActivity {

    String host = "101.37.33.136";
    int post = 1883;
    private Connection mGg;

    //银
    //Gg.Midle.Sliver.Real
//钯
    //Gg.Midle.Palladium.Real
//铂
    //Gg.Midle.Platinum.Real
//    String Topic = "Gg.Midle.Sliver.Real";
    String Topic = "Gg.Midle.Quote.Sliver";

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String obj = (String) msg.obj;
            Toast.makeText(Main2Activity.this,obj,Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Connection connection = Connection.createConnection(Constants.GG_Line, "android" + System.currentTimeMillis(), host, post, this, false);

            //connection.addNewSubscription(new Subscription(Topic,0,Topic,false));
        //connection.setSubscription(new Subscription(Topic,0,Topic,false));
        Connections.getInstance(this).addConnection(connection);

        Button turn = (Button) findViewById(R.id.turn);

        turn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,KlineActivity.class));
            }
        });
    }
}
