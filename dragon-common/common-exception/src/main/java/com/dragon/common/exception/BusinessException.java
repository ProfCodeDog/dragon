package com.dragon.common.exception;

import com.dragon.common.envm.ISuffixCode;

/**
 * @Description: 业务异常
 */
public class BusinessException extends RuntimeException {

    protected String code;

    public BusinessException(ISuffixCode suffixCode) {
        super(suffixCode.getFullMessage());
        this.code = suffixCode.getFullCode();
    }

    public BusinessException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public BusinessException(String code, String msg, Throwable cause) {
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
