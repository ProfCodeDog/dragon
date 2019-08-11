package com.dragon.data.rabbit.controller;

import com.dragon.data.rabbit.producer.DemoProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/data/rabbit/producer/demo")
public class DemoRabbitProducerController {


    @Autowired
    private DemoProducer demoProducer;

    @RequestMapping("/hello")
    public String hello() {
        testStringSend();
        return "www.machineswift.com";
    }


    public void testStringSend() {
        for (int i = 0; i < 10; i++) {
            demoProducer.send();
        }
    }
}
