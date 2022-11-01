package org.tinder.service;

import org.springframework.stereotype.Service;
import org.tinder.model.UserEntity;
import org.tinder.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}
