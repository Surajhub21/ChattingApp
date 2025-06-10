package com.ChattingRoom.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebPageController {

    @GetMapping("/")
    public String home() {
        return "home"; // will load home.html from templates
    }

    @GetMapping("/chat/{room}")
    public String chatRoom(@PathVariable String room) {
        return "room"; // will load room.html from templates
    }

}
