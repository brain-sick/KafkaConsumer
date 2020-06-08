package com.aj.kafkaConsumer.utility;

import com.aj.kafkaConsumer.domain.KafkaProduced;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;



//checking jersy get/post


//        String output = response.getEntity(String.class);
//
//        System.out.println("Output from Server .... \n");
//        System.out.println(output);

public class InvokeAPI {
    private KafkaProduced kafkaProduced;
    public InvokeAPI(KafkaProduced kafkaProduced){
        this.kafkaProduced = kafkaProduced;
    }
    public ClientResponse sendGGINotification(){
        Client client = new Client();
        WebResource webResource = client.resource("http://31.193.128.45/");
        String postJson = "";
        ClientResponse response = webResource.accept("application/json").post(ClientResponse.class,postJson);
        return response;
    }
}
