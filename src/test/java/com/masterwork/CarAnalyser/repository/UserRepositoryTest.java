package com.masterwork.CarAnalyser.repository;

import com.masterwork.CarAnalyser.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;


    @Test
    void shouldReadAndWriteUser() {
        User expected = userRepository.save(new User());
        Optional<User> actual = userRepository.findById(expected.getId());

        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());
    }


}
