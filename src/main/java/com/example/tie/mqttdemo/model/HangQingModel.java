package com.example.tie.mqttdemo.model;

/**
 * Created by tie on 2017/4/27.
 */

public class HangQingModel {


    /**
     * code : 200
     * data : {"ask":"3833.0000","bid":"3825.0000","bit":4,"currency":"CNY","exchange":"230","high":"3840.0000","last":"3825.0000","low":"3823.0000","market":"23","open":"3830.0000","preClose":"3839.0000","productId":"GDAG","pruductName":"粤贵银","timestamp":1493279835,"tradedate":1493222400,"type":0}
     * message : 成功
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * ask : 3833.0000
         * bid : 3825.0000
         * bit : 4
         * currency : CNY
         * exchange : 230
         * high : 3840.0000
         * last : 3825.0000
         * low : 3823.0000
         * market : 23
         * open : 3830.0000
         * preClose : 3839.0000
         * productId : GDAG
         * pruductName : 粤贵银
         * timestamp : 1493279835
         * tradedate : 1493222400
         * type : 0
         */

        private String ask;
        private String bid;
        private int bit;
        private String currency;
        private String exchange;
        private String high;
        private int last;
        private String low;
        private String market;
        private String open;
        private int preClose;
        private String productId;
        private String pruductName;
        private long timestamp;
        private int tradedate;
        private int type;

        public String getAsk() {
            return ask;
        }

        public void setAsk(String ask) {
            this.ask = ask;
        }

        public String getBid() {
            return bid;
        }

        public void setBid(String bid) {
            this.bid = bid;
        }

        public int getBit() {
            return bit;
        }

        public void setBit(int bit) {
            this.bit = bit;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getExchange() {
            return exchange;
        }

        public void setExchange(String exchange) {
            this.exchange = exchange;
        }

        public String getHigh() {
            return high;
        }

        public void setHigh(String high) {
            this.high = high;
        }

        public int getLast() {
            return last;
        }

        public void setLast(int last) {
            this.last = last;
        }

        public String getLow() {
            return low;
        }

        public void setLow(String low) {
            this.low = low;
        }

        public String getMarket() {
            return market;
        }

        public void setMarket(String market) {
            this.market = market;
        }

        public String getOpen() {
            return open;
        }

        public void setOpen(String open) {
            this.open = open;
        }

        public int getPreClose() {
            return preClose;
        }

        public void setPreClose(int preClose) {
            this.preClose = preClose;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getPruductName() {
            return pruductName;
        }

        public void setPruductName(String pruductName) {
            this.pruductName = pruductName;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public int getTradedate() {
            return tradedate;
        }

        public void setTradedate(int tradedate) {
            this.tradedate = tradedate;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
