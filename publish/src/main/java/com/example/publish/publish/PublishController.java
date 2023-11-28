package com.example.publish.publish;

import com.example.publish.kafka.KafkaProducer;
import com.example.publish.kafka.TopicType;
import lombok.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PublishController {

    private final KafkaProducer kafkaProducer;

    @PostMapping("/publish")
    public PublishDto publish(
            @RequestBody PublishDto publishDto
    ) {
        kafkaProducer.sendMessage(TopicType.ACTION, publishDto);
        return publishDto;
    }
}
