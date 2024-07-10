package com.codersCampus.chatapp.web;

import com.codersCampus.chatapp.domain.User;
import com.codersCampus.chatapp.dto.Response;
import com.codersCampus.chatapp.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;
    private static final Logger logger = (Logger) LoggerFactory.getLogger(LoginController.class);

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showloginPage() {
        return "login";
    }

    @PostMapping(consumes ="application/json", produces = "application/json")
    public Response processLogin(@RequestBody User user) {
        logger.info("Received login request for user{}");
        if (user.getUsername() != null && !user.getUsername().isEmpty()) {
            userService.addUser(user);
            return new Response(true);
        } else {
            return new Response(false);
        }
    }



}
