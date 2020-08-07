package com.vtb.kortunov.lesson22.controllers;

import com.vtb.kortunov.lesson22.entities.User;
import com.vtb.kortunov.lesson22.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String getAllBoxes(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "all_users";
    }

    @PostMapping("/add")
    public String addNewBox(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users/all";
    }
}
