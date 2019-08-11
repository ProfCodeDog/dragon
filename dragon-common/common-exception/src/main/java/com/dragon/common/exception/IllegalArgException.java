package com.dragon.common.exception;

import com.dragon.common.envm.ISuffixCode;

/**
 *  @Description: 非法参数
 */
public class IllegalArgException extends RuntimeException {

    protected String code;

    public IllegalArgException(ISuffixCode suffixCode) {
        super(suffixCode.getFullMessage());
        this.code = suffixCode.getFullCode();
    }

    public IllegalArgException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public IllegalArgException(String code, String msg, Throwable cause) {
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
