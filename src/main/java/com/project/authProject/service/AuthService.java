package com.project.authProject.service;

import com.project.authProject.entities.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthService {
    private List<User> userList = new ArrayList<>();

    public boolean register(String username, String password) {
        String salt = BCrypt.gensalt();
        String hashedPassword = BCrypt.hashpw(password, salt);

        User newUser = new User(username, hashedPassword);
        userList.add(newUser);

        return true;
    }

    public boolean login(String username, String password) {
        User user1 = userList.stream().filter(user -> user.getUsername().equals(username)).findFirst().get();
        boolean check = BCrypt.checkpw(password, user1.getHashedPassword());
        return check;
    }
}
