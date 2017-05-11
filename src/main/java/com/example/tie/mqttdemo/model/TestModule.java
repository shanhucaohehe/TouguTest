package com.example.tie.mqttdemo.model;

import com.example.tie.mqttdemo.utils.Callback;
import com.example.tie.mqttdemo.utils.HttpRequest;

/**
 * Created by tie on 2017/4/18.
 */

public class TestModule {

    private RequestParam mParam;

    //中盘交易接口_登录接口
    public void test0(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.login");
        mParam.put("Account","520147896369547");
        mParam.put("Passwd","123456");

        new HttpRequest(callback).postRequest(mParam);
    }

    //中盘交易接口_批量平仓
    public void test1(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.req.closemaretmany");
        mParam.put("Account","520147896369547");
        mParam.put("CommodityID","100001");
        mParam.put("Weight","80");
        mParam.put("Quantity","3");
        mParam.put("TradeRange","50");
        mParam.put("CloseDirector","1");

        new HttpRequest(callback).postRequest(mParam);
    }

    //中盘交易接口_限价建仓
    public void test2(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.req.openlimit");
        mParam.put("Account","520147896369547");
        mParam.put("CommodityID","100001");
        mParam.put("ExpireType","1");
        mParam.put("OpenDirector","1");
        mParam.put("Weight","80");
        mParam.put("Quantity","3");
        mParam.put("OrderPrice","100");
        mParam.put("SLPrice","99");
        mParam.put("TPPrice","98");

        new HttpRequest(callback).postRequest(mParam);
    }

    //中盘交易接口_限价平仓
    public void test3(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.req.closelimit");
        mParam.put("Account","520147896369547");
        mParam.put("CommodityID","100001");
        mParam.put("ClosePrice","2");
        mParam.put("ExpireType","1");
        mParam.put("HoldPositionID","10000012120");
        mParam.put("SLPrice","99");
        mParam.put("TPPrice","100");
        mParam.put("SLPrice","98");

        new HttpRequest(callback).postRequest(mParam);
    }

    //中盘交易接口_撤销限价单接口
    public void test4(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.req.limitrevoke");
        mParam.put("Account","520147896369547");
        mParam.put("LimitOrderID","12");
        mParam.put("LimitType","1");

        new HttpRequest(callback).postRequest(mParam);
    }

    //中盘交易接口_查询客户可出资金，用于出金操作
    public void test5(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.req.moneyquery");
        mParam.put("Account","520147896369547");

        new HttpRequest(callback).postRequest(mParam);
    }

    //中盘交易接口_客户资金流水查询接口
    public void test6(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.req.fundflowquery");
        mParam.put("Account","520147896369547");
        mParam.put("QueryType","1");
        mParam.put("BeginDate","111");
        mParam.put("EndDate","1");
        mParam.put("BeginRow","11");
        mParam.put("EndRow","2");
        mParam.put("OperType","1");

        new HttpRequest(callback).postRequest(mParam);
    }

    //中盘交易接口_出入金(提现操作)
    public void test7(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.req.moneyinout");
        mParam.put("Account","520147896369547");
        mParam.put("OperateType","1");
        mParam.put("Currency","100");
        mParam.put("Amount","888");
        mParam.put("FundPsw","honglu");
        mParam.put("BankPsw","ibcc");
        mParam.put("Reversedc","abd");
        mParam.put("PayType","1");
        mParam.put("OperateFlag","1");

        new HttpRequest(callback).postRequest(mParam);
    }

    //中盘交易接口_修改登陆密码
    public void test8(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.req.loginpwdupd");
        mParam.put("Account","520147896369547");
        mParam.put("OldPasswd","old");
        mParam.put("NewPasswd","news");
        mParam.put("MarketType","1");

        new HttpRequest(callback).postRequest(mParam);
    }

    //中盘交易接口_根据商品ID，获取交割的配置信息
    public void test9(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.req.opendeliverorder");
        mParam.put("Account","520147896369547");
        mParam.put("CommodityID","100001");
        mParam.put("HoldPositionID","10000012120");
        mParam.put("DeliveryCommodityID","121");
        mParam.put("AppDesc","AppDesc");

        new HttpRequest(callback).postRequest(mParam);
    }

    //中盘交易接口_银行签约成功通知接口
    public void test10(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.req.signresultnotifyquery");
        mParam.put("Account","520147896369547");
        mParam.put("BankID","1");
        mParam.put("BankAccount","ICBC");

        new HttpRequest(callback).postRequest(mParam);
    }

    //中盘交易接口_支付推进接口
    public void test11(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.req.payforward");
        mParam.put("Account","520147896369547");
        mParam.put("Ticket","abc");
        mParam.put("IdentifyCode","abci");
        mParam.put("Reversed","call");

        new HttpRequest(callback).postRequest(mParam);
    }

    //中盘交易接口_市价平仓
    public void test12(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.req.closemarket");
        mParam.put("Account","520147896369547");
        mParam.put("HoldPositionID","10000012120");
        mParam.put("CommodityID","100001");
        mParam.put("Weight","80");
        mParam.put("Quantity","3");
        mParam.put("TradeRange","50");

        new HttpRequest(callback).postRequest(mParam);
    }

    //中盘交易接口_请求所有持仓单信息
    public void test13(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.req.holdpositiontotal");
        mParam.put("Account","520147896369547");

        new HttpRequest(callback).postRequest(mParam);
    }

    //中盘交易接口_获取用户信息
    public void test14(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.get.accountinfo");
        mParam.put("Account","520147896369547");

        new HttpRequest(callback).postRequest(mParam);
    }

    //中盘交易接口_根据商品ID，获取其市价建仓的配置信息
    public void test15(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.get.openmarketconf");
        mParam.put("Account","520147896369547");
        mParam.put("CommodityID","100001");

        new HttpRequest(callback).postRequest(mParam);
    }

    //中盘交易接口_获取市场状态
    public void test16(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.get.marketstatus");
        mParam.put("Account","520147896369547");

        new HttpRequest(callback).postRequest(mParam);
    }

    //中盘交易接口_根据商品ID，获取其限价建仓的配置信息
    public void test17(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.get.openlimitconf");
        mParam.put("Account","520147896369547");
        mParam.put("CommodityID","100001");

        new HttpRequest(callback).postRequest(mParam);
    }

    //中盘交易接口_根据商品ID，获取其市价平仓的配置信息
    public void test18(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.req.closemarket");
        mParam.put("Account","520147896369547");
        mParam.put("CommodityID","100001");

        new HttpRequest(callback).postRequest(mParam);
    }

    //中盘交易接口_根据商品ID，获取其限价平仓的配置信息
    public void test19(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.get.closelimitconf");
        mParam.put("Account","520147896369547");
        mParam.put("CommodityID","100001");


        new HttpRequest(callback).postRequest(mParam);
    }

    //中盘交易接口_根据商品ID，获取其限价平仓的配置信息
    public void test20(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.get.closelimitconf");
        mParam.put("Account","520147896369547");
        mParam.put("CommodityID","100001");

        new HttpRequest(callback).postRequest(mParam);
    }

    //中盘交易接口_根据商品ID，获取交割的配置信息
    public void test21(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.get.opendeliverconf");
        mParam.put("Account","520147896369547");
        mParam.put("CommodityID","100001");
        mParam.put("HoldWeight","2");
        mParam.put("HoldPrice","3000");

        new HttpRequest(callback).postRequest(mParam);
    }

    //中盘交易接口_请求商品行情
    public void test22(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.req.quote");
        mParam.put("Account","520147896369547");

        new HttpRequest(callback).postRequest(mParam);
    }

    //中盘交易接口_请求持仓信息
    public void test23(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.req.hodeposition");
        mParam.put("Account","520147896369547");

        new HttpRequest(callback).postRequest(mParam);
    }
    //中盘交易接口_请求限价单信息
    public void test24(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.req.limitorders");
        mParam.put("Account","520147896369547");

        new HttpRequest(callback).postRequest(mParam);
    }

    //中盘交易接口_请求平仓单信息
    public void test25(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.req.closeorders");
        mParam.put("Account","520147896369547");

        new HttpRequest(callback).postRequest(mParam);
    }

    //中盘交易接口_修改或查询客户是否可以登录
    public void test26(Callback callback) {
        mParam = new RequestParam("pemc.mid.trade.req.customerallowlogin");
        mParam.put("Account","520147896369547");
        mParam.put("AllowLogin","222");

        new HttpRequest(callback).postRequest(mParam);
    }

    //获取行情快照
    public void test27(Callback callback) {
        mParam = new RequestParam("pemc.mid.quote.snapshot");
        mParam.put("productId","GDAG");

        new HttpRequest(callback).postKlineRequest(mParam);
    }

    //获取K线接口
    public void test28(Callback callback) {
        mParam = new RequestParam("pemc.mid.quote.kLine");
        mParam.put("productId","1min");
        mParam.put("kLineType","222");
        mParam.put("startTime","1436864169");

        new HttpRequest(callback).postKlineRequest(mParam);
    }

    //获取分时线接口
    public void test29(Callback callback) {
        mParam = new RequestParam("pemc.mid.quote.shareLine");
        mParam.put("productId","GDAG");
        mParam.put("shareType","1min");

        new HttpRequest(callback).postKlineRequest(mParam);
    }

}
