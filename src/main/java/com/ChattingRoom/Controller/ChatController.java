package com.ChattingRoom.Controller;

import com.ChattingRoom.Entity.ChatMessage;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat/{room}/sendMessage")
    @SendTo("/topic/{room}")
    public ChatMessage sendMessage(@DestinationVariable String room,
                                   @Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat/{room}/addUser")
    @SendTo("/topic/{room}")
    public ChatMessage addUser(@DestinationVariable String room,
                               @Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {

        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        headerAccessor.getSessionAttributes().put("room", room);

        chatMessage.setType(ChatMessage.MessageType.JOIN);
        return chatMessage;
    }
}
