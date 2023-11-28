package com.example.publish.kafka;

import com.example.publish.publish.PublishDto;
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

    public void sendMessage (PublishDto publishDto){
        String messageJson = null;
        try {
            messageJson = mapper.writeValueAsString(publishDto.toContent());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        kafkaTemplate.send(publishDto.getTopicType().getTopicName(), messageJson);
    }
}