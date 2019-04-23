package com.example.spring_transaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EventMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
        demoPublisher.publish("Hello Application Event");
        context.close();
    }
}
