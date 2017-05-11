package com.example.tie.mqttdemo.model;

/**
 * 广贵中盘登录
 * Created by tie on 2017/4/18.
 */

public class GmLoginEntity{


    /**
     * Type : pemc.mid.trade.login
     * Param : {"Account":"520147896369547","Passwd":"123456"}
     */

    private String Type;
    private ParamBean Param;

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public ParamBean getParam() {
        return Param;
    }

    public void setParam(ParamBean Param) {
        this.Param = Param;
    }

    public static class ParamBean {
        /**
         * Account : 520147896369547
         * Passwd : 123456
         */

        private String Account;
        private String Passwd;

        public String getAccount() {
            return Account;
        }

        public void setAccount(String Account) {
            this.Account = Account;
        }

        public String getPasswd() {
            return Passwd;
        }

        public void setPasswd(String Passwd) {
            this.Passwd = Passwd;
        }

        public ParamBean(String account, String passwd) {
            Account = account;
            Passwd = passwd;
        }
    }

    public GmLoginEntity(String type, ParamBean param) {
        Type = type;
        Param = param;
    }
}
