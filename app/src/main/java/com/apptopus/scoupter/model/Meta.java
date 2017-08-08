package com.apptopus.scoupter.model;

public class Meta {

    private String serverTime;
    private int status;
    private String key;

    public Meta(String serverTime, int status, String key) {
        this.serverTime = serverTime;
        this.status = status;
        this.key = key;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
