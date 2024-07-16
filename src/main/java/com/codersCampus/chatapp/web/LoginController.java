package com.codersCampus.chatapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, Model model) {
        if (username != null && !username.isEmpty()) {
            model.addAttribute("username", username);
            return "redirect:/chat?username=" + username;
        } else {
            model.addAttribute("error", "Username is required.");
            return "login";
        }
    }

    @GetMapping("/chat")
    public String showChatPage(@RequestParam String username, Model model) {
            model.addAttribute("username", username);
            return "generalChat";
    }

    @GetMapping("/channels/general")
    public String showGeneralPage(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        return "generalChat";
    }

    @GetMapping("channels/privat")
    public String showPrivatPage(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        return "privatChat";
    }

}


