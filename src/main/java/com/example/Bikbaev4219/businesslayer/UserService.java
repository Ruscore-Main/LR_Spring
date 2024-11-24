package com.example.Bikbaev4219.businesslayer;

import com.example.Bikbaev4219.entities.User;
import com.example.Bikbaev4219.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }
    public User save(User toSave) {
        return userRepository.save(toSave);
    }
}