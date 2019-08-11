package com.dragon.data.rabbit.envm;

public enum ExchangeEnum {

    DIRECT_EXCHANGE("direct.exchange", "直连交换机"),
    FANOUT_EXCHANGE("fanout.exchange", "扇形交换机"),
    TOPIC_EXCHANGE("topic.exchange", "主题交换机"),
    HEADERS_EXCHANGE("headers.exchange", "首部交换机");

    private String code;
    private String name;

    ExchangeEnum(String code, String name) {
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
