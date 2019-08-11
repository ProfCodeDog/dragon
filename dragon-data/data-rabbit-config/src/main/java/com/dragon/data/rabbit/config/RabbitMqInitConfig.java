package com.dragon.data.rabbit.config;

import com.dragon.data.rabbit.envm.ExchangeEnum;
import com.dragon.data.rabbit.envm.QueueName;
import com.dragon.data.rabbit.envm.RoutingKeyEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqInitConfig {

    /**
     * 声明交换器
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(ExchangeEnum.DIRECT_EXCHANGE.getCode());
    }

    @Bean
    public FanoutExchange FanoutExchange() {
        return new FanoutExchange(ExchangeEnum.FANOUT_EXCHANGE.getCode());
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(ExchangeEnum.TOPIC_EXCHANGE.getCode());
    }

    @Bean
    public HeadersExchange headersExchange() {
        return new HeadersExchange(ExchangeEnum.HEADERS_EXCHANGE.getCode());
    }

    /**
     * 声明队列
     */
    @Bean
    public Queue demoQueue() {
        return new Queue(QueueName.QUEUE_COM_DRAGON_DEMO);
    }

    /**
     * 绑定队列路由键和交换器
     */
    @Bean
    public Binding bindingLogLoginQueueWithDirectExchange() {
        return BindingBuilder.bind(demoQueue()).to(directExchange())
                .with(RoutingKeyEnum.ROUTING_KEY_COM_DRAGON_DEMO.getCode());
    }

}
