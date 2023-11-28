package com.example.point.point;

import com.example.core.kafka.dto.KafkaDataDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final ObjectMapper mapper;

    @KafkaListener(topics = {"action_topic", "event_topic"})
    public void listen(String message) {
        KafkaDataDto.Content kafkaDataDto;
        try {
            kafkaDataDto = mapper.readValue(message, KafkaDataDto.Content.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        log.info("Received Message: {}", message);
        log.info("Received KafkaDataDto: {}", kafkaDataDto);
    }
}
