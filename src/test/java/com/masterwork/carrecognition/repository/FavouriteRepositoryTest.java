package com.masterwork.carrecognition.repository;

import com.masterwork.carrecognition.model.Favourite;
import com.masterwork.carrecognition.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class FavouriteRepositoryTest {

    @Autowired
    FavouriteRepository favouriteRepository;
    @Autowired
    UserRepository userRepository;


    @Test
    void shouldReadAndWriteFavourite() {
        User user = userRepository.save(new User());
        Favourite toSave = new Favourite().builder()
                .header("Audi")
                .imageUrl("/image.jpg")
                .user(user).build();
        Favourite expected = favouriteRepository.save(toSave);
        Optional<Favourite> actual = favouriteRepository.findById(expected.getId());

        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());
    }
}
