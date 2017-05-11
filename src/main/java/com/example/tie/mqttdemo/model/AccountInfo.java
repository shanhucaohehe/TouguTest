package com.example.tie.mqttdemo.model;

/**
 * Created by tie on 2017/4/18.
 */

public class AccountInfo {


    /**
     * Param : {"Account":"520147896369547","Passwd":"123456"}
     * Response : {"Finish":1,"Success":1,"sid":""}
     * Type : pemc.mid.trade.login
     */

    private ParamBean Param;
    private ResponseBean Response;
    private String Type;

    public ParamBean getParam() {
        return Param;
    }

    public void setParam(ParamBean Param) {
        this.Param = Param;
    }

    public ResponseBean getResponse() {
        return Response;
    }

    public void setResponse(ResponseBean Response) {
        this.Response = Response;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
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
    }

    public static class ResponseBean {
        /**
         * Finish : 1
         * Success : 1
         * sid :
         */

        private int Finish;
        private int Success;
        private String sid;

        public int getFinish() {
            return Finish;
        }

        public void setFinish(int Finish) {
            this.Finish = Finish;
        }

        public int getSuccess() {
            return Success;
        }

        public void setSuccess(int Success) {
            this.Success = Success;
        }

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "Param=" + Param +
                ", Response=" + Response +
                ", Type='" + Type + '\'' +
                '}';
    }
}
