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
     * error : null
     * result : {"_id":"58e45db7eb342f266ce732b0","userPhone":"18661965247","password":"7c4a8d09ca3762af61e59520943dc26494f8941b","create_time":"2017-04-05T02:56:58.706Z","title":"筑基","level":"1级","experience":0,"signature":"我发誓今天起再也不抽烟了","nick_name":"戒友1491361018706"}
     * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1OGU0NWRiN2ViMzQyZjI2NmNlNzMyYjAiLCJ1c2VyUGhvbmUiOiIxODY2MTk2NTI0NyIsImlhdCI6MTQ5MTM2MTQyNywiZXhwIjoxNDkxNDQ3ODI3fQ.T8hKn7F5Vx0UCNks3EMmtpK4KYlnbhuLoP8aMp01y10
     */

    private boolean success;
    private String error;
    private ResultBean result;
    private String token;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
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

    public static class ResultBean {
        /**
         * _id : 58e45db7eb342f266ce732b0
         * userPhone : 18661965247
         * password : 7c4a8d09ca3762af61e59520943dc26494f8941b
         * create_time : 2017-04-05T02:56:58.706Z
         * title : 筑基
         * level : 1级
         * experience : 0
         * signature : 我发誓今天起再也不抽烟了
         * nick_name : 戒友1491361018706
         */

        private String _id;
        private String userPhone;
        private String password;
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
    }
}
