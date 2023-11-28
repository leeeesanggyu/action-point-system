package com.example.publish.kafka;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TopicType {
    ACTION("action_topic")
    ;

    private final String topicName;
}