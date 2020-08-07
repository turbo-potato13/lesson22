package com.vtb.kortunov.lesson22.services;

import com.vtb.kortunov.lesson22.entities.User;
import com.vtb.kortunov.lesson22.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.get(id);
    }

    public List<User> getUsers() {
        return userRepository.getAll();
    }
}
