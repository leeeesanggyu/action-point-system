package com.example.publish.publish;

import com.example.core.kafka.dto.KafkaDataDto;
import com.example.publish.kafka.KafkaProducer;
import lombok.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PublishController {

    private final KafkaProducer kafkaProducer;

    @PostMapping("/publish")
    public KafkaDataDto publish(
            @RequestBody KafkaDataDto kafkaDataDto
    ) {
        kafkaProducer.sendMessage(kafkaDataDto);
        return kafkaDataDto;
    }
}
