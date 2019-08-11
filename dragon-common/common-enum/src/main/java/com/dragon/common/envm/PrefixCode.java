package com.dragon.common.envm;

/**
 * 编码前缀(四位数字)
 */
public enum PrefixCode {

    COMMON("0000", ""),
    AUTHORIZATION("0001", "认证模块"),

    LOGIN("0900", "登陆模块"),
    USER("1000", "用户模块");

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    PrefixCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private final String code;
    private final String message;
}
