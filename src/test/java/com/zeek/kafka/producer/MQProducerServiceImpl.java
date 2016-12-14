package com.zeek.kafka.producer;

/**
 * Created by weibo_li on 16/8/1.
 */
public class MQProducerServiceImpl {

    public static void main(String[] args) {

        String metadataBrokerList = "localhost:9092" ;

        String requestRequiredACKs = "1" ;

        String serializerClass = "kafka.serializer.StringEncoder" ;

        MQProducer mqProducer = null;
        String topic = "test" ;


        try {
            Object object = null;
            mqProducer = new MQProducer(metadataBrokerList, requestRequiredACKs, serializerClass);
            int count = 0;
            while(count < 10) {
                object = new SendData("hello"+count, 2 + count);
                mqProducer.send(topic, object);
                Thread.sleep(1000);
                count--;
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } finally {
            mqProducer.close();
        }
    }
}
