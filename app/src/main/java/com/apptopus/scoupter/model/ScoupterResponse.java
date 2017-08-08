package com.apptopus.scoupter.model;

import com.google.gson.annotations.SerializedName;

public class ScoupterResponse<T> {
    @SerializedName("meta")
    private Meta meta;
    @SerializedName("data")
    private T data;

    public ScoupterResponse(Meta meta, T data) {
        this.meta = meta;
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
