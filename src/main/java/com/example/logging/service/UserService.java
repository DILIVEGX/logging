package com.example.logging.service;

import com.example.logging.model.User;
import com.example.logging.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        logger.info("Retrieved {} users", users.size());
        return users;
    }

    public User createUser(User user) {
        if (user == null) {
            logger.warn("Attempted to create a null user");
            return null;
        }
        User savedUser = userRepository.save(user);
        logger.info("Created user with ID {}", savedUser.getId());
        return savedUser;
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            logger.warn("Attempted to delete non-existent user with ID {}", id);
            return;
        }
        userRepository.deleteById(id);
        logger.info("Deleted user with ID {}", id);
    }
}


