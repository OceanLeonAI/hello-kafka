package com.leon.hello.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * @PROJECT_NAME: hello-kafka
 * @CLASS_NAME: TestKafkaAPI
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/11/18 13:53
 * @Version 1.0
 * @DESCRIPTION:
 **/
public class KafkaConsumerAPITest {

    // Kafka集群地址
    private static final String brokerList = "192.168.11.208:9092";
    // 主题名称-之前已经创建
    private static final String topic = "topic-first";
    // 消费组
    private static final String groupId = "group.demo";

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("bootstrap.servers", brokerList);
        properties.put("group.id", groupId);

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Collections.singletonList(topic));

        while (true) {
            ConsumerRecords<String, String> records =
                    consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record.value());
            }
        }

    }
}
