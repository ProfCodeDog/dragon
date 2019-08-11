package com.dragon.common.envm;

import java.util.regex.Pattern;

public enum CommonPattern implements IPattern {

    MOBILE(Pattern.compile("\"^1[0-9]{10}$\""), "手机号格式不正确(1开头的11位数字)");


    CommonPattern(Pattern pattern, String message) {
        this.pattern = pattern;
        this.message = message;
    }

    @Override
    public Pattern getPattern() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }

    private final Pattern pattern;
    private final String message;
}
