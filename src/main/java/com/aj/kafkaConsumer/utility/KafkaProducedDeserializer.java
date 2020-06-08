package com.aj.kafkaConsumer.utility;

import com.aj.kafkaConsumer.domain.KafkaProduced;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class KafkaProducedDeserializer implements Deserializer {
    @Override
    public void configure(Map configs, boolean isKey) {

    }

    @Override
    public Object deserialize(String arg1, byte[] data) {
        ObjectMapper mapper = new ObjectMapper();
        KafkaProduced kafkaProduced = null;
        try {
            kafkaProduced = mapper.readValue(data, KafkaProduced.class);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return kafkaProduced;
    }

    @Override
    public void close() {

    }
}
