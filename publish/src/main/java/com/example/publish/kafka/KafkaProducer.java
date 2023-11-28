package com.example.publish.kafka;

import com.example.core.kafka.dto.KafkaDataDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper mapper;

    public void sendMessage (KafkaDataDto kafkaDataDto){
        String messageJson = null;
        try {
            messageJson = mapper.writeValueAsString(kafkaDataDto.toContent());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        kafkaTemplate.send(kafkaDataDto.getTopicType().getTopicName(), messageJson);
    }
}