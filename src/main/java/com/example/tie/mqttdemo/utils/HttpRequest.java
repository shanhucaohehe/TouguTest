package com.example.tie.mqttdemo.utils;

import android.util.Log;

import com.example.tie.mqttdemo.PullPersonService;
import com.example.tie.mqttdemo.model.RequestParam;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.PostStringBuilder;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.request.RequestCall;

import java.io.UnsupportedEncodingException;

import okhttp3.Call;

/**
 * HTTP请求工具类
 *
 * @author TAO
 */
public class HttpRequest {

    /**
     * 应用版本
     */
    private String versionName;

    private String TAG = "HttpRequest";
    /**
     * 应用包名
     */
    private String packageName;

    private boolean DEBUG = true;

    private HttpRequest mHttprequest;

    private Callback mCallback;


    public HttpRequest(Callback callback) {
        mCallback = callback;
    }

    /**
     * POST方式请求服务器
     * <p>
     * 请求参数
     *
     * @return 返回字符串
     * @throws UnsupportedEncodingException
     */
    public void postRequest(RequestParam param) {
        if (param == null) {
            return;
        }

        if (DEBUG) {
            Log.e(TAG, "请求参数========" + param.toString());
        }

        PostStringBuilder postStringBuilder = OkHttpUtils.postString();


        String url = "http://101.37.33.121:8090/trade.cgi";

        postStringBuilder.url(url);

        RequestCall build = postStringBuilder.content(param.getResult()).build();

        build.execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                if (DEBUG && e.getMessage() != null) {
                    Log.e(TAG, "response==========" + e.getMessage());
                }

                mCallback.onErrorResponse(e.getMessage());


            }

            @Override
            public void onResponse(String response, int id) {
                if (DEBUG && response != null) {
                    Log.e(TAG, "response==========" + response);
                }
                try {
                    if(response != null) {
                        String response1 = PullPersonService.getResponse(response);
                        String jsonResponse = response1.substring(0, response1.length() - 1);
                        mCallback.onResponse(jsonResponse);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onAfter(int id) {
                super.onAfter(id);
            }
        });
    }


    /**
     * POST方式请求服务器
     * <p>
     * 请求参数
     *
     * @return 返回字符串
     * @throws UnsupportedEncodingException
     */
    public void postKlineRequest(RequestParam param) {
        if (param == null) {
            return;
        }

        if (DEBUG) {
            Log.e(TAG, "请求参数========" + param.toString());
        }

        PostStringBuilder postStringBuilder = OkHttpUtils.postString();


        String url = "http://101.37.33.121:8080/quote.cgi";

        postStringBuilder.url(url);

        RequestCall build = postStringBuilder.content(param.getKlineResult()).build();

        build.execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                if (DEBUG && e.getMessage() != null) {
                    Log.e(TAG, "response==========" + e.getMessage());
                }

                mCallback.onErrorResponse(e.getMessage());


            }

            @Override
            public void onResponse(String response, int id) {
                if (DEBUG && response != null) {
                    Log.e(TAG, "response==========" + response);
                }
                try {
                    if(response != null) {
                        String response1 = PullPersonService.getResponse(response);
                        String jsonResponse = response1.substring(0, response1.length() - 1);
                        mCallback.onResponse(jsonResponse);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onAfter(int id) {
                super.onAfter(id);
            }
        });
    }


}
