package com.example.Bikbaev4219.persistence;

import com.example.Bikbaev4219.entities.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserById(Long id);
}