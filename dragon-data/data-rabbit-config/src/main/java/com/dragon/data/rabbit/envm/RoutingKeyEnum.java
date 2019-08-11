package com.dragon.data.rabbit.envm;

public enum RoutingKeyEnum {

    ROUTING_KEY_COM_DRAGON_DEMO("routing.key.com.dragon.demo", "demo routing key");

    private String code;
    private String name;

    RoutingKeyEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
