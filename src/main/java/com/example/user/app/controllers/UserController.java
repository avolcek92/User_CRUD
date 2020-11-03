package com.example.user.app.controllers;

import com.example.user.app.entities.User;
import com.example.user.app.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String showInitialScreen(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users",users);
        return "index";
    }
    @GetMapping("/signup")
    public String showSingUpForm(User user){
        return "user-add";
    }
    @PostMapping("/adduser")
    public String addUser(User user, BindingResult result,Model model){
        userRepository.save(user);
        model.addAttribute("users",userRepository.findAll());
        return "index";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("Invalid user id: " + id));
        userRepository.delete(user);
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        model.addAttribute("user", user);
        return "user-edit";
    }
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, Model model, User user, BindingResult result) {
        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

}