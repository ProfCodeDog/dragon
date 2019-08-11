package com.dragon.common.exception;

/**
 * @Description: 系统不支持功能异常
 */
public class UnSupportException extends RuntimeException {

    protected String code;

    public UnSupportException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public UnSupportException(String code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
