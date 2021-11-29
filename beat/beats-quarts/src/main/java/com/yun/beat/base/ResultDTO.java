package com.yun.beat.base;

import java.io.Serializable;

/**
 * @author lmy
 * @date 2021/7/7 16:18
 */
public class ResultDTO implements Serializable {
    private int code;

    private String msg;

    private Object data;

    private int count;
    public ResultDTO(ResultCode code, Object result) {
        this.code = code.getCode();
        this.msg = code.getErrorDesc();
        this.data = result;
    }

    public ResultDTO(ResultCode code, String errorDesc, Object result) {
        this.code = code.getCode();
        this.msg = errorDesc;
        this.data = result;
    }

    public ResultDTO(int code, String errorDesc, Object result) {
        this.code = code;
        this.msg = errorDesc;
        this.data = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
