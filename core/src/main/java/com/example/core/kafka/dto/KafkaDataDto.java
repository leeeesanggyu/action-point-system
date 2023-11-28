package com.example.core.kafka.dto;

import lombok.*;

@Getter
@NoArgsConstructor
public class KafkaDataDto {

    private TopicType topicType;
    private ActionType actionType;
    private Long userId;

    @Builder
    private KafkaDataDto(TopicType topicType, ActionType actionType, Long userId) {
        this.topicType = topicType;
        this.actionType = actionType;
        this.userId = userId;
    }

    public Content toContent() {
        return new Content(actionType, userId);
    }

    @ToString
    @Getter
    @AllArgsConstructor
    public static class Content {
        private ActionType actionType;
        private Long userId;
    }
}
