package com.dragon.common.exception;

import com.dragon.common.envm.CommonSuffixCode;

/**
 * @Description: 通用异常
 */
public class CommonException extends RuntimeException {

    protected String code;

    public CommonException(CommonSuffixCode resultCode) {
        super(resultCode.getFullMessage());
        this.code = resultCode.getFullCode();
    }

    public String getCode() {
        return code;
    }
}
