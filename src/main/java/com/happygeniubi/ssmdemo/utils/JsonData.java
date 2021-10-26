package com.happygeniubi.ssmdemo.utils;

import lombok.Data;

@Data
public class JsonData {

    private int code;

    private Object data;

    private String msg;

    public JsonData(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
    public JsonData(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public static JsonData buildSuccess(Object data) {
        return new JsonData(200, data);
    }

    public static JsonData buildError(String msg) {
        return new JsonData(500, "", msg);
    }

    public static JsonData buildError(String msg, int code) {
        return new JsonData(code, "", msg);
    }
}
