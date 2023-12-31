package com.masterwork.carrecognition.repository;

import com.masterwork.carrecognition.model.Favourite;
import com.masterwork.carrecognition.model.User;
import com.masterwork.carrecognition.repository.data.FavouriteRepositoryTestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class FavouriteRepositoryTest extends FavouriteRepositoryTestData {

    @Autowired
    FavouriteRepository favouriteRepository;
    @Autowired
    UserRepository userRepository;


    @Test
    void shouldReadAndWriteFavourite() {
        User user = userRepository.save(new User());
        Favourite toSave = generateFavourite(user);
        Favourite expected = favouriteRepository.save(toSave);
        Optional<Favourite> actual = favouriteRepository.findById(expected.getId());

        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());
    }

    @Test
    @Sql("/test_data.sql")
    void shouldFindAllByUserId() {
        User user = userRepository.findById(1L).orElseThrow();
        List<Favourite> actual = favouriteRepository.findAllByUserId(user.getId());
        List<Favourite> expected = generateTestData(user);
        assertEquals(expected, actual);
    }
}
