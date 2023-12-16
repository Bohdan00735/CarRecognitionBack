package com.masterwork.carrecognition.repository.data;

import com.masterwork.carrecognition.model.Favourite;
import com.masterwork.carrecognition.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FavouriteRepositoryTestData {

    protected Favourite generateFavourite(User user) {
        return new Favourite().builder()
                .header("Audi")
                .imageUrl("/image.jpg")
                .user(user).build();
    }

    protected List<Favourite> generateTestData(User user) {
        return Arrays.asList(
                new Favourite().builder()
                        .id(2L)
                        .header("Audi")
                        .imageUrl("1.jpg")
                        .user(user)
                        .build(),
                new Favourite().builder()
                        .id(3L)
                        .header("Mers")
                        .imageUrl("2.jpg")
                        .user(user)
                        .build());
    }

}
