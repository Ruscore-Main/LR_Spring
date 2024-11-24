package com.example.Bikbaev4219.presentation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Bikbaev4219.businesslayer.UserService;
import com.example.Bikbaev4219.entities.User;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        User createdUser = userService.save(new User(
                user.getId(), user.getUsername(),
                user.getFirstName(), user.getLastName()));
        return createdUser;
    }
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id) {
        return userService.findUserById(id);
    }
}
