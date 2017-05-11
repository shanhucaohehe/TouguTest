package com.example.tie.mqttdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.tie.mqttdemo.model.HangQingModel;
import com.example.tie.mqttdemo.model.TestModule;
import com.example.tie.mqttdemo.mqtt.internal.Connection;
import com.example.tie.mqttdemo.mqtt.internal.Connections;
import com.example.tie.mqttdemo.mqtt.internal.IReceivedMessageListener;
import com.example.tie.mqttdemo.mqtt.model.ReceivedMessage;
import com.example.tie.mqttdemo.mqtt.model.Subscription;
import com.example.tie.mqttdemo.utils.Callback;
import com.example.tie.mqttdemo.utils.Constants;
import com.example.tie.mqttdemo.utils.NumberUtils;
import com.google.gson.Gson;
import com.honglu.klinechart.Constans;
import com.honglu.klinechart.PagerFragment;
import com.honglu.klinechart.ckchart.KChartAdapter;
import com.honglu.klinechart.ckchart.KChartView;
import com.honglu.klinechart.ckchart.KLineEntity;
import com.honglu.klinechart.ckchart.utils.DeviceUtils;

import org.eclipse.paho.client.mqttv3.MqttException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 专业 K 线图
 */
public class KLineFragment extends PagerFragment {

    private KChartAdapter mAdapter;
    private KChartView mProfKChartView;
    private ProgressBar mLoadingProgress;
    private TextView mPoint;
    private TextView mChangePoint;
    private TextView mChangePercent;
    private TextView mTime;
    private TextView mHangqing;

    private String type;
    Timer timer;
    TimerTask timerTask;


    private String mTypeCode;
    private Connection mConnection;

    String Topic = "Gg.Midle.Quote.Sliver";

    HangQingModel hangQingModel;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 99:
                    if (timer != null) {
                        timer.cancel();
                        timer = null;
                    }
                    if (timerTask != null) {
                        timerTask.cancel();
                        timerTask = null;
                    }
                    String obj = (String) msg.obj;
                    hangQingModel = new Gson().fromJson(obj, HangQingModel.class);
                    initDate(hangQingModel);
                    break;
                case 100:
                    //getKLine();
                    break;
            }

        }
    };
    private HangQingModel.DataBean mData;
    private Subscription mSubscription;

    //加载数据
    private void initDate(HangQingModel hangQingModel) {
        mData = hangQingModel.getData();
        //最新
        mPoint.setText(mData.getLast() + "");
        //时间
        long date1 = mData.getTimestamp() * 1000L;
        Date date = new Date(date1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        mTime.setText(time);
        //变化的点数
        int changePoint = mData.getLast() - mData.getPreClose();
        mChangePoint.setText(changePoint + "");
        //变化的比率
        mChangePercent.setText(NumberUtils.getFloatStr2(changePoint*1f / mData.getPreClose()));

        //
        mHangqing.setText("最高 " + mData.getHigh() + "  最低 " + mData.getLow() + "\n  今开  " + mData.getOpen() + "  昨收  " + mData.getPreClose());
    }

    @Override
    protected int doGetContentLayout() {
        return R.layout.fragment_professional_kline;
    }

    @Override
    protected void doInit(View root) {
        mLoadingProgress = (ProgressBar) getRootView().findViewById(R.id.loading_progress);
        mProfKChartView = (KChartView) getRootView().findViewById(R.id.ly_professional_kline);
        mTime = (TextView) getRootView().findViewById(R.id.time);
        mPoint = (TextView) getRootView().findViewById(R.id.point);
        mChangePoint= (TextView) getRootView().findViewById(R.id.change_point);
        mChangePercent = (TextView) getRootView().findViewById(R.id.change_percent);
        mHangqing = (TextView) getRootView().findViewById(R.id.hangqing);
        mAdapter = new KChartAdapter();
        mProfKChartView.setAdapter(mAdapter);
        mProfKChartView.setOverScrollRange(DeviceUtils.dip2px(getContext(), 100));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Bundle arguments = getArguments();
//        if (arguments != null) {
//            type = arguments.getString("type");
//            try {
//                mTypeCode = arguments.getString("typeCode");
//                if (TextUtils.isEmpty(mTypeCode)){
//                    mTypeCode = Constans.sTypeCode;
//                }
//            }catch (Exception e){
//            }
//        }

        mConnection = Connections.getInstance(getActivity()).getConnection(Constants.GG_Line);

        try {
            mSubscription = new Subscription(Topic,0,Topic,false);
            mConnection.addNewSubscription(mSubscription);

        } catch (MqttException e) {
            e.printStackTrace();
        }

        mConnection.addReceivedMessageListner(new IReceivedMessageListener() {
            @Override
            public void onMessageReceived(ReceivedMessage message) {
                Message msg = new Message();
                msg.what = 99;
                msg.obj = new String(message.getMessage().getPayload());
                mHandler.sendMessage(msg);
            }
        });

        timer = new Timer();

       timerTask = new TimerTask() {

            @Override
            public void run() {
               getKLine();
                System.out.println("时间");
            }
        };

        timer.schedule(timerTask, 0, 1000);//第三个参数代表休眠2秒，即我们定义的重复周期

    }

    public void getKLine() {
        new TestModule().test27(new Callback() {
            @Override
            public void onResponse(String response) {
                HangQingModel hangQingModel = new Gson().fromJson(response, HangQingModel.class);
                initDate(hangQingModel);
            }

            @Override
            public void onErrorResponse(String message) {

            }
        });
    }

    @Override
    protected void onVisible() {
        super.onVisible();
        setData();
    }

    public void setData() {
        List<KLineEntity> kLineEntities = Constans.parseKLine();
        mAdapter.setData(kLineEntities);
        mLoadingProgress.setVisibility(View.GONE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (timerTask != null) {
            timerTask.cancel();
            timerTask = null;
        }
        if(mSubscription!= null)
            try {
                mConnection.unsubscribe(mSubscription);
            } catch (MqttException e) {
                e.printStackTrace();
            }
    }
}
