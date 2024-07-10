package com.codersCampus.chatapp.web;

import com.codersCampus.chatapp.domain.User;
import com.codersCampus.chatapp.dto.Response;
import com.codersCampus.chatapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showloginPage() {
        return "login";
    }

    @PostMapping
    public String processLogin(@RequestParam("username") String username, Model model) {
        System.out.println("username entered: " + username);

        if(username != null && !username.isEmpty()) {
            User user = new User();
            user.setUsername(username);
            userService.addUser(user);
            model.addAttribute("username", username);
            return "chat";
        }else{
            return "redirect:/login?erro";
        }
    }
    @PostMapping(value ="/api", consumes ="application/json", produces = "application/json")
    @ResponseBody
    public Response processLoginApi(@RequestBody User user) {
        System.out.println("Username entered in API; " + user.getUsername());

        if (user.getUsername() != null && !user.getUsername().isEmpty()) {
            userService.addUser(user);
            return new Response(true);
        } else {
            return new Response(false);
        }
    }



}
