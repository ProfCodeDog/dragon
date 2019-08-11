package com.dragon.data.rabbit.consumer;

import com.alibaba.fastjson.JSON;
import com.dragon.common.bean.entity.ResultEntity;
import com.dragon.data.rabbit.envm.QueueName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DemoConsumer {

    private final Logger log = LoggerFactory.getLogger(getClass());


    @RabbitListener(queues = QueueName.QUEUE_COM_DRAGON_DEMO, containerFactory = "singleListenerContainer")
    public void consumeUserLogQueue(ResultEntity message) {
        try {
            log.info("mq demo,loginLog:{}", JSON.toJSONString(message));
        } catch (Exception e) {
            log.error("mq demo,exception:{}", e);
        }
    }
}
