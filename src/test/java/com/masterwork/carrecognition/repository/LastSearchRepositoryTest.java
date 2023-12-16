package com.masterwork.carrecognition.repository;

import com.masterwork.carrecognition.model.LastSearch;
import com.masterwork.carrecognition.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class LastSearchRepositoryTest {

    @Autowired
    LastSearchRepository lastSearchRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    void shouldReadAndWriteFavourite() {
        User user = userRepository.save(new User());
        LastSearch toSave = new LastSearch().builder()
                .header("Audi")
                .imageUrl("/image.jpg")
                .user(user).build();
        LastSearch expected = lastSearchRepository.save(toSave);
        Optional<LastSearch> actual = lastSearchRepository.findById(expected.getId());

        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());
    }

}
