package com.aj.kafkaConsumer;

import com.aj.kafkaConsumer.domain.KafkaProduced;
import com.aj.kafkaConsumer.utility.InvokeAPI;
import com.aj.kafkaConsumer.utility.ValidateKafkaProduced;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.log4j.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasicKafkaConsumer {
    //private final Logger logger = LoggerFactory.getLogger(BasicKafkaConsumer.class);

    public static void main(String[] args) throws Exception {

//        Client client = new Client();
//        WebResource webResource = client.resource("http://31.193.128.45/");
//        String postJson = "";
//        ClientResponse response = webResource.accept("application/json").post(ClientResponse.class,postJson);
//        if (response.getStatus() != 200) {
//            System.out.println("Cannot establish connection!");
//        }
//        else{
//            System.out.println(response.getEntity(String.class));
//
//        }

        String topic = args[0];

        Properties props = new Properties();
        ConsumerProperties consumerProperties = new ConsumerProperties(props);
        consumerProperties.setProperty();

        //KafkaConsumer<String, KafkaProduced> consumer = new KafkaConsumer<>(props);
        //logger.info("Starting Kafka Consumer...");
        System.out.println("Starting Kafka Consumer...");
        try (KafkaConsumer<String, KafkaProduced> consumer = new KafkaConsumer<>(props)) {
            consumer.subscribe(Arrays.asList(topic));
            //logger.info("Kafka Consumer subscribed to topic: {}", topic);
            while (true) {
                // return 1 record per poll
                ConsumerRecords<String, KafkaProduced> messages = consumer.poll(Duration.ofMillis(100));
                if(messages.count()>0)
                    System.out.println(messages.count());
                for (ConsumerRecord<String, KafkaProduced> kafkaProduced : messages) {
                    System.out.println("Message received " + kafkaProduced.value().toString());
                    if (new ValidateKafkaProduced(kafkaProduced.value()).isValid()) {
                        ClientResponse response = new InvokeAPI(kafkaProduced.value()).sendGGINotification();
                        System.out.println("status : " + response.getStatus());
                        if(response.getStatus() != 200) {
                            TimeUnit.MINUTES.sleep(1);
                        }
                    }
                }
                consumer.commitSync();
            }
        } catch (Exception e) {
            System.out.println("Error reading for Kafka Topic");
        }
    }
}

