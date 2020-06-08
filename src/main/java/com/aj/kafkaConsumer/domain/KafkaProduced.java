package com.aj.kafkaConsumer.domain;


import java.util.List;

public class KafkaProduced {
    private String owner_id;
    private String trip_id;
    private List<String> guest_ids;
    @Override
    public String toString(){
        String result= owner_id + " " + trip_id + " Guests : ";
        for(String guest:guest_ids){
            result += (guest+" ");
        }
        return result;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public String getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }

    public List<String> getGuest_ids() {
        return guest_ids;
    }

    public void setGuest_ids(List<String> guest_ids) {
        this.guest_ids = guest_ids;
    }

}