package com.example.tie.mqttdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.tie.mqttdemo.model.TestModule;
import com.example.tie.mqttdemo.utils.Callback;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class Main3Activity extends AppCompatActivity {

    private String str = "{\"Type\":\"pemc.mid.trade.login\",\"Param\":{\"Account\":\"520147896369547\",\"Passwd\":\"123456\"}}";
    private TextView mView;

    SoapSerializationEnvelope envelope;
    HttpTransportSE ht;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mView = (TextView) findViewById(R.id.text_result);

        // WSDL文档的URL，192.168.17.156为PC的ID地址
        String serviceUrl = "http://101.37.33.121:8090/trade.wsdl";
        // 定义调用的WebService方法名
        String methodName = "trade";
        // 第1步：创建SoapObject对象，并指定WebService的命名空间和调用的方法名
        SoapObject request = new SoapObject("urn:trade", methodName);
        // 第2步：设置WebService方法的参数
        request.addProperty("request", str);
        // 第3步：创建SoapSerializationEnvelope对象，并指定WebService的版本
        envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        // 设置bodyOut属性
        envelope.bodyOut = request;
        // 第4步：创建HttpTransportSE对象，并指定WSDL文档的URL
        ht = new HttpTransportSE(serviceUrl);

//        new Thread() {
//            @Override
//            public void run() {
//                try {
//                    ht.call(null, envelope);
//
//                    if (envelope.getResponse() != null) {
//                        // 第6步：使用getResponse方法获得WebService方法的返回结果
//                        SoapObject soapObject = (SoapObject) envelope.bodyIn;
//                        // 通过getProperty方法获得Product对象的属性值
//                        String result = soapObject.getProperty(0).toString();
//
//                        System.out.println(result);
//                        //                result += "产品数量：" + soapObject.getProperty("productNumber") + "\n";
//                        //                result += "产品价格：" + soapObject.getProperty("price");
//                        // mView.setText(result);
//
//                    } else {
//                        mView.setText("无此产品.");
//                    }
//                } catch (Exception soapFault) {
//                    soapFault.printStackTrace();
//                }
//            }
//        }.start();

//        String requestParam = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><soapenv:Body><trade xmlns=\"urn:trade\"><request xmlns=\"\">{&quot;Type&quot;:&quot;pemc.mid.trade.get.accountinfo&quot;,&quot;Param&quot;:{&quot;Account&quot;:&quot;180000000000003&quot;}}</request></trade></soapenv:Body></soapenv:Envelope>\n" +
//                "\n";


        TestModule test = new TestModule();

        Callback callback = new Callback() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
            }

            @Override
            public void onErrorResponse(String message) {
                System.out.println(message);
            }
        };
//        test.test0(callback);
//        test.test1(callback);
//        test.test2(callback);
//        test.test3(callback);
//        test.test4(callback);
//        test.test5(callback);
//        test.test6(callback);
//        test.test7(callback);
//        test.test8(callback);
//        test.test9(callback);
//        test.test10(callback);
//        test.test11(callback);
//        test.test12(callback);
//        test.test13(callback);
//        test.test14(callback);
//        test.test15(callback);
//        test.test16(callback);
//        test.test17(callback);
//        test.test18(callback);
//        test.test19(callback);
//        test.test20(callback);
//        test.test21(callback);
//        test.test22(callback);
//        test.test23(callback);
//        test.test24(callback);
//        test.test25(callback);
//        test.test26(callback);
//        test.test27(callback);
        test.test28(callback);
        test.test29(callback);
    }
}
