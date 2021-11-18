package com.leon.hello.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @PROJECT_NAME: hello-kafka
 * @CLASS_NAME: KafkaProducerAPITest
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/11/18 13:53
 * @Version 1.0
 * @DESCRIPTION:
 **/
public class KafkaProducerAPITest {
    // 主题名称-之前已经创建
    private static final String topic = "topic-first";
    // Kafka集群地址
    private static final String brokerList = "192.168.11.208:9092";

    public static void main(String[] args) {
        Properties properties = new Properties();
        // 设置key序列化器
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //设置重试次数
        properties.put(ProducerConfig.RETRIES_CONFIG, 10);

        // 设置值序列化器
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        //设置集群地址
        properties.put("bootstrap.servers", brokerList);

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
        ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(topic, "kafka-demo", "hello.kafka 20211118 23!!!");

        try {
            producer.send(producerRecord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        producer.close();
    }

}
