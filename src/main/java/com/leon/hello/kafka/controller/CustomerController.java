package com.leon.hello.kafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @PROJECT_NAME: hello-kafka
 * @CLASS_NAME: CustomerController
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/11/18 12:47
 * @Version 1.0
 * @DESCRIPTION:
 **/
@Slf4j
@Component
public class CustomerController {

    /**
     * topics = "demo" 要消费的topic名称
     *
     * @param record
     */
    @KafkaListener(topics = "topic-first")
    public void listen(ConsumerRecord<?, ?> record) {
        log.info("topic是: {}, offset是: {}, value是: {}", record.topic(), record.offset(), record.value());
    }

}
