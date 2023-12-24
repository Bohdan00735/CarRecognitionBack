package com.masterwork.carrecognition.service.impl;

import com.masterwork.carrecognition.model.User;
import com.masterwork.carrecognition.repository.UserRepository;
import com.masterwork.carrecognition.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public User createUser() {

        User user = userRepository.save(new User());
        log.info("User created: " + user);
        return user;
    }
}
