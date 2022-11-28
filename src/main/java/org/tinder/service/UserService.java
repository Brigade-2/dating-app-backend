package org.tinder.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tinder.model.UserEntity;
import org.tinder.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<Iterable<UserEntity>> getAllUsers(String gender,
                                                            Integer ageRangeStart,
                                                            Integer ageRangeEnd,
                                                            List<String> tags) {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<UserEntity> addUser(UserEntity user) {
        configureUserEntity(user);
        return new ResponseEntity<>(this.userRepository.save(user), HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteUser(Long id) {
        final Optional<UserEntity> user = this.userRepository.findById(id);

        if (user.isPresent()) {
            this.userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<UserEntity> getUserById(Long id) {
        final Optional<UserEntity> user = this.userRepository.findById(id);

        return user.map(userEntity -> new ResponseEntity<>(userEntity, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    private void configureUserEntity(UserEntity user) {
        user.setCreationDate(LocalDate.now());
    }
}
