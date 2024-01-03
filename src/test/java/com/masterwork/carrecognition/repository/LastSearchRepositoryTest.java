package com.masterwork.carrecognition.repository;

import com.masterwork.carrecognition.model.LastSearch;
import com.masterwork.carrecognition.model.User;
import com.masterwork.carrecognition.repository.data.LastSearchRepositoryTestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class LastSearchRepositoryTest extends LastSearchRepositoryTestData {

    @Autowired
    LastSearchRepository lastSearchRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    void shouldReadAndWriteFavourite() {
        User user = userRepository.save(new User());
        LastSearch toSave = generateFavourite(user);
        LastSearch expected = lastSearchRepository.save(toSave);
        Optional<LastSearch> actual = lastSearchRepository.findById(expected.getId());

        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());
    }

    @Test
    @Sql("/test_data.sql")
    void shouldFindAllByUserId() {
        User user = userRepository.findById(1L).orElseThrow();
        List<LastSearch> actual = lastSearchRepository.findAllByUserId(user.getId());
        List<LastSearch> expected = generateTestData(user);
        assertEquals(expected, actual);
    }

    @Test
    @Sql("/test_data_2.sql")
    void shouldFindAllByUserIdAndDateN(){
        User user = userRepository.findById(1L).orElseThrow();
        List<LastSearch> actual = lastSearchRepository.findTopNByUserIdOrderByDateDesc(user.getId(), PageRequest.of(0,2));
        System.out.println(actual);
    }
}
