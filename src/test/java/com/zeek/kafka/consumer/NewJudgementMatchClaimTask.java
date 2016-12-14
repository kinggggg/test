package com.zeek.kafka.consumer;

import com.google.gson.Gson;
import com.zeek.kafka.producer.SendData;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;

import java.nio.charset.Charset;

public class NewJudgementMatchClaimTask implements Runnable {

    private KafkaStream kafkaStream;

    public NewJudgementMatchClaimTask(KafkaStream kafkaStream) {
        this.kafkaStream = kafkaStream;
    }

    @Override
    public void run() {
        ConsumerIterator<byte[], byte[]> iterator = this.kafkaStream.iterator();

        while (iterator.hasNext()) {
            String jsonMessage = new String(iterator.next().message(), Charset.forName("utf-8"));
            System.out.print(jsonMessage);
            SendData sendData = new Gson().fromJson(jsonMessage,
                    SendData.class);

            System.out.println(sendData);

        }
    }
}
