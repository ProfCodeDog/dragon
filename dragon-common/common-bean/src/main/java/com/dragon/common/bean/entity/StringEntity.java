package com.dragon.common.bean.entity;

public final class StringEntity {

    public StringEntity() {
    }

    public StringEntity(String result) {
        this.result = result;
    }

    private String result;

    public final String getResult() {
        return result;
    }

    public final void setResult(String result) {
        this.result = result;
    }
}
