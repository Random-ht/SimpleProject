package com.ht.random.model;

import cn.droidlover.xdroidmvp.net.IModel;

/**
 * Created by gxjkz on 2018/1/3.
 */

public class UserLoginReturn implements IModel {
    /**
     * code : 0
     * info_en : success
     * info_cn : 成功
     * info : {"uid":"f7d762e5-1418-40be-bad6-a33abb11ecd4","token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzVGVsZXBob25lIjoxMzM4NzYxNzE1MiwicGFzcyI6InFxcTEyMyIsImlhdCI6MTUxNDI3MTMzNiwiZXhwIjoxNTE0ODc2MTM2fQ.JUBx7b22ohTOgsdxKxt7EH39mYplds1pmaaYr8YtGT0"}
     */

    private int code;
    private String info_en;
    private String info_cn;
    private InfoBean info;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo_en() {
        return info_en;
    }

    public void setInfo_en(String info_en) {
        this.info_en = info_en;
    }

    public String getInfo_cn() {
        return info_cn;
    }

    public void setInfo_cn(String info_cn) {
        this.info_cn = info_cn;
    }

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public boolean isAuthError() {
        return false;
    }

    @Override
    public boolean isBizError() {
        return false;
    }

    @Override
    public String getErrorMsg() {
        return null;
    }

    public static class InfoBean {
        /**
         * uid : f7d762e5-1418-40be-bad6-a33abb11ecd4
         * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzVGVsZXBob25lIjoxMzM4NzYxNzE1MiwicGFzcyI6InFxcTEyMyIsImlhdCI6MTUxNDI3MTMzNiwiZXhwIjoxNTE0ODc2MTM2fQ.JUBx7b22ohTOgsdxKxt7EH39mYplds1pmaaYr8YtGT0
         */

        private String uid;
        private String token;
        private String info;

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
