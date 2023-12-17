package com.masterwork.carrecognition.controller.data;

import com.masterwork.carrecognition.dto.FavouriteDto;
import com.masterwork.carrecognition.model.Favourite;
import com.masterwork.carrecognition.model.User;

import java.util.Arrays;
import java.util.List;

public class FavouriteRestControllerTestData {

    protected List<Favourite> generateFavourites() {
        return Arrays.asList(
                new Favourite().builder()
                        .id(2L)
                        .header("Audi")
                        .imageUrl("1.jpg")
                        .user(new User(1L))
                        .build(),
                new Favourite().builder()
                        .id(3L)
                        .header("Mers")
                        .imageUrl("2.jpg")
                        .user(new User(1L))
                        .build());
    }

    protected List<FavouriteDto> generateFavoritesDto() {
        return Arrays.asList(
                new FavouriteDto().builder()
                        .header("Audi")
                        .imageUrl("1.jpg")
                        .build(),
                new FavouriteDto().builder()
                        .header("Mers")
                        .imageUrl("2.jpg")
                        .build()
        );
    }
}
