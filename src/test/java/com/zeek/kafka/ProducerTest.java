package com.zeek.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @ClassName ProducerTest
 * @Description
 * @Author liweibo
 * @Date 2018/10/30 下午5:39
 * @Version v1.0
 **/
public class ProducerTest {

    public static void main(String[] args) throws Exception {

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092"); //必须指定
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"); //必须指定
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer"); //必须指定
        props.put("acks", "-1");
        props.put("retries", 3);
        props.put("batch.size", 323840);
        props.put ("linger.ms", 10) ;
        props.put ("buffer.memory", 33554432);
        props.put ("max.block.ms", 3000);
        Producer<String, String> producer= new KafkaProducer<>(props);
        for(int i = 0; i < 10; i++)
            producer.send(new ProducerRecord<>("test",
                    Integer.toString(i), Integer . toString(i )));
        producer.close();
    }
}
