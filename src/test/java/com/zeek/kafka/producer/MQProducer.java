package com.zeek.kafka.producer;



import com.google.gson.Gson;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import java.util.Properties;

public class MQProducer {

    private ProducerConfig producerConfig;

    private Producer<String, String> producer;

    public MQProducer(String metadataBrokerList, String requestRequiredACKs, String serializerClass) {
        Properties props = new Properties();
        props.setProperty("metadata.broker.list", metadataBrokerList);
        props.setProperty("request.required.acks", requestRequiredACKs);
        props.setProperty("serializer.class", serializerClass);

        this.producerConfig = new ProducerConfig(props);
        this.producer = new Producer<>(producerConfig);
    }

    public void send(String topic, Object object) {
        String json = new Gson().toJson(object);
        KeyedMessage<String, String> keyedMessage = new KeyedMessage<>(topic, json);
        producer.send(keyedMessage);
    }

    public void close() {
        this.producer.close();
    }
}
