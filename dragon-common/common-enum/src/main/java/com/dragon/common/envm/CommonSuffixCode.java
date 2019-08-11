package com.dragon.common.envm;

/**
 * 编码后缀(四位数字)
 */
public enum CommonSuffixCode implements ISuffixCode {

    SUCCESS("0000", "SUCCESS"),

    ACCOUNT_NOT_LOGIN("0401", "账号未登陆,请登录"),
    TOKEN_HAS_EXPIRE("0402", "token过期,请登录"),
    TOKEN_NOT_CORRECT("0403", "token不正确"),

    API_NOT_EXISTS("0500", "接口不存在"),
    API_NOT_SUPPORT_REQUEST_METHOD("0501", "接口不支持请求方法"),

    API_NOT_PERMISSION("0550", "接口没有访问权限"),

    API_PARAMETER_EXCEPTION("0550", "接口参数异常"),

    IP_UNKNOWN("1000", "非法IP请求"),

    ACCOUNT_NOT_PERMISSION("1403", "没有权限,联系管理员"),

    SYSTEM_ERROR("9909", "系统异常");

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getFullCode() {
        return new StringBuilder(PrefixCode.COMMON.getCode()).
                append(code).toString();
    }

    @Override
    public String getFullMessage() {
        return message;
    }

    CommonSuffixCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private final String code;
    private final String message;
}
