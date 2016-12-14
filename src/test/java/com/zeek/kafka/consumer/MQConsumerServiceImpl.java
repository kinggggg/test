package com.zeek.kafka.consumer;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class will be instantiated on startup of tomcat,
 * then the consumer will be awaiting incoming messages
 */
public class MQConsumerServiceImpl {

    public static void main(String[] args) {

        String topic = "test" ;

        String zookeeperConnect = "localhost:2181" ;

        String autoCommitIntervalMs = "1000" ;

        String zookeeperSessionTimeoutMs = "4000" ;

        ExecutorService executorService;

        ConsumerConnector consumerConnector;

        ConsumerConfig consumerConfig = null;

        Properties props = new Properties();
        props.put("zookeeper.connect", zookeeperConnect);
        props.put("auto.commit.interval.ms", autoCommitIntervalMs);// This is the interval in which it will commit the message offset to the zookeeper
        props.put("zookeeper.session.timeout.ms", zookeeperSessionTimeoutMs);//
        props.put("group.id", "myGroup");
        consumerConfig = new ConsumerConfig(props);

        consumerConnector = Consumer.createJavaConsumerConnector(consumerConfig);

        Map<String, Integer> topicMap = new HashMap<>();
        topicMap.put(topic, 1);

        Map<String, List<KafkaStream<byte[], byte[]>>> streamMap = consumerConnector.createMessageStreams(topicMap);
        KafkaStream<byte[], byte[]> kafkaStream = streamMap.get(topic).get(0);

        executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new NewJudgementMatchClaimTask(kafkaStream));



    }
}