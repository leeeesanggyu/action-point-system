package com.example.publish.kafka;

import com.example.publish.publish.PublishController;
import com.example.publish.publish.PublishDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.publish.kafka.TopicType.ACTION;
import static com.example.publish.kafka.TopicType.EVENT;
import static com.example.publish.publish.ActionType.PAYMENT_SUCCESS;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KafkaProducerTest {

    @Autowired
    KafkaProducer kafkaProducer;

    @Test
    void sendMessage() {
        PublishDto publishDto = PublishDto.builder()
                .topicType(EVENT)
                .actionType(PAYMENT_SUCCESS)
                .userId(1L)
                .build();
        kafkaProducer.sendMessage(publishDto);
    }
}