package com.example.publish.kafka;

import com.example.core.kafka.dto.ActionType;
import com.example.core.kafka.dto.KafkaDataDto;
import com.example.core.kafka.dto.TopicType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KafkaProducerTest {

    @Autowired
    KafkaProducer kafkaProducer;

    @Test
    void sendMessage() {
        KafkaDataDto publishDto = KafkaDataDto.builder()
                .topicType(TopicType.EVENT)
                .actionType(ActionType.PAYMENT_SUCCESS)
                .userId(1L)
                .build();
        kafkaProducer.sendMessage(publishDto);
    }
}