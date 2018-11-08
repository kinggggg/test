package com.zeek.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.Properties;

/**
 * @ClassName ProducerTest
 * @Description
 * @Author liweibo
 * @Date 2018/10/30 下午5:39
 * @Version v1.0
 **/
public class ConsumerTest {

    @Test
    public void test01() throws Exception {
        String topicName = "test" ;
        String groupId = "test-group" ;

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092"); //必须指定
        props.put("group.id", groupId); //必须指定
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "earliest"); //从最早的消息开始读取
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"); //必须指定 根据序列化后的值确定消息存储到哪个分区
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"); //必须指定

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList(topicName));
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(1000);
                for(ConsumerRecord<String, String> record : records) {
                    System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                }
            }
        }finally {
            consumer.close();
        }

    }
}
