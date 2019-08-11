package com.dragon.data.rabbit.producer;

import com.dragon.common.bean.entity.ResultEntity;
import com.dragon.data.rabbit.envm.ExchangeEnum;
import com.dragon.data.rabbit.envm.RoutingKeyEnum;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        ResultEntity entity = new ResultEntity();

        entity.setCode("11111");
        entity.setSuccess(true);
        entity.setMsg("成功");

        // 第一个参数为刚刚定义的队列名称
        this.rabbitTemplate.convertAndSend(ExchangeEnum.DIRECT_EXCHANGE.getCode(),
                RoutingKeyEnum.ROUTING_KEY_COM_DRAGON_DEMO.getCode(), entity);
    }
}
