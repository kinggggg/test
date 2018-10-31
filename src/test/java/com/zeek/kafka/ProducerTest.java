package com.zeek.kafka;

import org.apache.kafka.clients.producer.*;

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
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"); //必须指定 根据序列化后的值确定消息存储到哪个分区
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer"); //必须指定
        props.put("acks", "-1"); // -1 所有的副本replication（包括主副本，从副本）均将消息写入后才给生产者客户端相应；0 不关心消息是否写入kafka，kafka直接返回给生产者客户端； 1 只要消息已经写入主分区副本后，kafka就返回给producer生产者客户端
        props.put("retries", 3); //当发送消息失败后，重试的次数
        props.put("batch.size", 323840); //发送缓冲区的大小 producer会将发往同一分区的多条消息封装进一个batch中
        props.put ("linger.ms", 10) ; //发送延时 producer发送消息时，会延时执行发送的时间
        props.put ("buffer.memory", 33554432); //设置发送缓冲区的大小 默认32MB
        props.put ("max.block.ms", 3000); //当缓冲区满或者metadata不可用时，指定Producer.send()方法最大的等待时间
        Producer<String, String> producer= new KafkaProducer<>(props);
        for(int i = 0; i < 10; i++)
            producer.send(new ProducerRecord<>("test",
                    Integer.toString(i), Integer.toString(i)), new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    /*
                     * 这里是发送结果的回调。
                     * 当exception不为null时发送失败，为null时发送成功
                     * 或者 当metadata不为null时发送成功，为null时发送失败
                     */
                    if(exception == null) {
                        System.out.println("消息发送成功");
                    }

                }
            });
        producer.close();
    }
}
