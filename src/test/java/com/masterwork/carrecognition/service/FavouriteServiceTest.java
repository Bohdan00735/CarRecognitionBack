package com.masterwork.carrecognition.service;

import com.masterwork.carrecognition.config.TestConfig;
import com.masterwork.carrecognition.dto.FavoriteExtendedDto;
import com.masterwork.carrecognition.model.Favourite;
import com.masterwork.carrecognition.model.User;
import com.masterwork.carrecognition.repository.FavouriteRepository;
import com.masterwork.carrecognition.repository.UserRepository;
import com.masterwork.carrecognition.service.impl.FavouriteServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = FavouriteServiceImpl.class)
@ContextConfiguration(classes = TestConfig.class)
public class FavouriteServiceTest {


    @MockBean
    FavouriteRepository favouriteRepository;
    @MockBean
    UserRepository userRepository;
    @Autowired
    FavouriteService favouriteService;

    @Test
    void shouldAddNewFavourite() {

        FavoriteExtendedDto toSave = new FavoriteExtendedDto("Audi", "1.jpg", 1L);
        User founded = new User(toSave.getUserId());
        Favourite favourite = new Favourite().builder()
                .header(toSave.getHeader())
                .imageUrl(toSave.getImageUrl())
                .user(founded)
                .build();
        Favourite saved = new Favourite().builder()
                .id(1L)
                .header(toSave.getHeader())
                .imageUrl(toSave.getImageUrl())
                .user(founded)
                .build();

        when(userRepository.findById(toSave.getUserId())).thenReturn(Optional.of(founded));
        when(favouriteRepository.save(favourite)).thenReturn(saved);

        favouriteService.addFavouriteToUser(toSave);

    }
}
