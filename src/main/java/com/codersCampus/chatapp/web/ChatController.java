package com.codersCampus.chatapp.web;

import com.codersCampus.chatapp.domain.Message;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChatController {

    private final List<String> messages = new ArrayList<>();

    @PostMapping("/sendMessage")
    public void sendMessage(@RequestBody Message message) {
        messages.add(message.getMessage());
    }

    @GetMapping("/getMessages")
    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }
}
