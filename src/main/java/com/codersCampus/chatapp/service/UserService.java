package com.codersCampus.chatapp.service;


import com.codersCampus.chatapp.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        System.out.println("Adding user: " + user.getUsername());
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
}
