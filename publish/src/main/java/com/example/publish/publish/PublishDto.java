package com.example.publish.publish;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PublishDto {

    private ActionType actionType;
    private Long userId;

    @Builder
    private PublishDto(ActionType actionType, Long userId) {
        this.actionType = actionType;
        this.userId = userId;
    }
}
