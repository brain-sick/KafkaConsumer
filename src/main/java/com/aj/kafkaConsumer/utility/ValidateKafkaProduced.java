package com.aj.kafkaConsumer.utility;

import com.aj.kafkaConsumer.domain.KafkaProduced;
import javafx.scene.control.TableRow;

public class ValidateKafkaProduced {
    private KafkaProduced kafkaProduced;
    public ValidateKafkaProduced(KafkaProduced kafkaProduced){
        this.kafkaProduced  = kafkaProduced;
    }
    public boolean isValid(){
        // validate kafkaProduced
        return true;
    }
}
