package com.example.tie.mqttdemo.model;

/**
 * Created by tie on 2017/4/18.
 */

public class Account {


    /**
     * Type : pemc.mid.trade.get.accountinfo
     * Param : {"Account":"180000000000003"}
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
         * Account : 180000000000003
         */

        private String Account;

        public String getAccount() {
            return Account;
        }

        public void setAccount(String Account) {
            this.Account = Account;
        }

        public ParamBean(String account) {
            Account = account;
        }
    }

    public Account(String type, ParamBean param) {
        Type = type;
        Param = param;
    }
}
