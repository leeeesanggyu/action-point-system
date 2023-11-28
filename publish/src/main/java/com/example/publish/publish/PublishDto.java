package com.example.publish.publish;

import com.example.publish.kafka.TopicType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PublishDto {

    private TopicType topicType;
    private ActionType actionType;
    private Long userId;

    @Builder
    private PublishDto(TopicType topicType, ActionType actionType, Long userId) {
        this.topicType = topicType;
        this.actionType = actionType;
        this.userId = userId;
    }

    public Content toContent() {
        return new Content(actionType, userId);
    }

    @Getter
    @AllArgsConstructor
    static class Content {
        private ActionType actionType;
        private Long userId;
    }
}
