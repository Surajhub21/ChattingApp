package com.ChattingRoom.Entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage {

    private String content;
    private String sender;
    private String room;
    private MessageType type;

    public enum MessageType{
        CHAT , JOIN , LEAVE
    }
}
