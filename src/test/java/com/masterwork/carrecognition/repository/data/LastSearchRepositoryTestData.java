package com.masterwork.carrecognition.repository.data;

import com.masterwork.carrecognition.model.Favourite;
import com.masterwork.carrecognition.model.LastSearch;
import com.masterwork.carrecognition.model.User;

import java.util.Arrays;
import java.util.List;

public class LastSearchRepositoryTestData {

    protected LastSearch generateFavourite(User user) {
        return new LastSearch().builder()
                .header("Audi")
                .imageUrl("/image.jpg")
                .user(user).build();
    }

    protected List<LastSearch> generateTestData(User user) {
        return Arrays.asList(
                new LastSearch().builder()
                        .id(4L)
                        .header("Mers")
                        .imageUrl("2.jpg")
                        .user(user)
                        .build(),
                new LastSearch().builder()
                        .id(5L)
                        .header("Porsh")
                        .imageUrl("4.jpg")
                        .user(user)
                        .build());
    }


}
