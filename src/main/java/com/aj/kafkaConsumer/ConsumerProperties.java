package com.aj.kafkaConsumer;

import java.util.Properties;
public class ConsumerProperties {
    private Properties property;

    public ConsumerProperties(Properties property){
        this.property = property;
    }
    public void setProperty(){
        property.put("bootstrap.servers", "localhost:9092");
        property.put("group.id", "group1");
//        property.put("enable.auto.commit", "true");
//        property.put("auto.commit.interval.ms", "1000");
        property.put("session.timeout.ms", "30000");
        property.put("max.poll.records","1");
        property.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        property.put("value.deserializer", "com.aj.kafkaConsumer.utility.KafkaProducedDeserializer");
    }
}
