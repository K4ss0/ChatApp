package com.codersCampus.chatapp.web;

import com.codersCampus.chatapp.domain.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChatController {

    private final List<Message> messages = new ArrayList<>();

    @PostMapping("/sendMessage")
    public ResponseEntity<Void> sendMessage(@RequestBody Message message) {
        messages.add(message);
        return ResponseEntity.ok().build();
        }

    @GetMapping("/getMessages")
    public ResponseEntity<List<Message>> getMessages() {
        return ResponseEntity.ok(messages);
        }

}
