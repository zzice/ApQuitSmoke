package com.z.ice.apquitsmoke.bean;

import java.io.Serializable;

/**
 * desc: UserBean
 * date: 2017/4/1
 * author: Zice
 */
public class UserBean implements Serializable {


    /**
     * success : true
     * error : false
     * result : {"_id":"58cb8372d4d7747e6caa0b4b","userPhone":"18661965240","password":"7c4a8d09ca3762af61e59520943dc26494f8941b","qs_start_date":"2017-03-17T09:03:27.132Z","smoke_info":{"tar":"0","price":"11","dayNum":"5"},"sc_start_date":"2017-03-20T09:12:56.052Z","planId":"58cb8372d4d7747e6caa0b4b","create_time":"2017-03-17T06:31:43.591Z","title":"筑基","level":"1级","experience":80,"signature":"我发誓今天起再也不抽烟了","nick_name":"戒友1489732303591"}
     * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1OGNiODM3MmQ0ZDc3NDdlNmNhYTBiNGIiLCJ1c2VyUGhvbmUiOiIxODY2MTk2NTI0MCIsImlhdCI6MTQ5MDAwNDMxNSwiZXhwIjoxNDkwMDkwNzE1fQ.crzHhqO8Va-Vi2O3bHn8zbvAjy5VF-CFHV21tR-_zZ4
     */

    private boolean success;
    private boolean error;
    private ResultBean result;
    private String token;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private static class ResultBean implements Serializable{
        /**
         * _id : 58cb8372d4d7747e6caa0b4b
         * userPhone : 18661965240
         * password : 7c4a8d09ca3762af61e59520943dc26494f8941b
         * qs_start_date : 2017-03-17T09:03:27.132Z
         * smoke_info : {"tar":"0","price":"11","dayNum":"5"}
         * sc_start_date : 2017-03-20T09:12:56.052Z
         * planId : 58cb8372d4d7747e6caa0b4b
         * create_time : 2017-03-17T06:31:43.591Z
         * title : 筑基
         * level : 1级
         * experience : 80
         * signature : 我发誓今天起再也不抽烟了
         * nick_name : 戒友1489732303591
         */

        private String _id;
        private String userPhone;
        private String password;
        private String qs_start_date;
        private SmokeInfoBean smoke_info;
        private String sc_start_date;
        private String planId;
        private String create_time;
        private String title;
        private String level;
        private int experience;
        private String signature;
        private String nick_name;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getUserPhone() {
            return userPhone;
        }

        public void setUserPhone(String userPhone) {
            this.userPhone = userPhone;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getQs_start_date() {
            return qs_start_date;
        }

        public void setQs_start_date(String qs_start_date) {
            this.qs_start_date = qs_start_date;
        }

        public SmokeInfoBean getSmoke_info() {
            return smoke_info;
        }

        public void setSmoke_info(SmokeInfoBean smoke_info) {
            this.smoke_info = smoke_info;
        }

        public String getSc_start_date() {
            return sc_start_date;
        }

        public void setSc_start_date(String sc_start_date) {
            this.sc_start_date = sc_start_date;
        }

        public String getPlanId() {
            return planId;
        }

        public void setPlanId(String planId) {
            this.planId = planId;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public int getExperience() {
            return experience;
        }

        public void setExperience(int experience) {
            this.experience = experience;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getNick_name() {
            return nick_name;
        }

        public void setNick_name(String nick_name) {
            this.nick_name = nick_name;
        }

        public static class SmokeInfoBean {
            /**
             * tar : 0
             * price : 11
             * dayNum : 5
             */

            private String tar;
            private String price;
            private String dayNum;

            public String getTar() {
                return tar;
            }

            public void setTar(String tar) {
                this.tar = tar;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getDayNum() {
                return dayNum;
            }

            public void setDayNum(String dayNum) {
                this.dayNum = dayNum;
            }
        }
    }
}
