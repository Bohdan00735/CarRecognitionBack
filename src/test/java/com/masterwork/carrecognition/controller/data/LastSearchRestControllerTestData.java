package com.masterwork.carrecognition.controller.data;

import com.masterwork.carrecognition.dto.LastSearchDto;
import com.masterwork.carrecognition.model.LastSearch;
import com.masterwork.carrecognition.model.User;

import java.util.Arrays;
import java.util.List;

public class LastSearchRestControllerTestData {

    protected List<LastSearch> generateLastSearches() {
        return Arrays.asList(
                new LastSearch().builder()
                        .id(2L)
                        .header("Audi")
                        .imageUrl("1.jpg")
                        .user(new User(1L))
                        .build(),
                new LastSearch().builder()
                        .id(3L)
                        .header("Mers")
                        .imageUrl("2.jpg")
                        .user(new User(1L))
                        .build());
    }

    protected List<LastSearchDto> generateLastSearchesDto() {
        return Arrays.asList(
                new LastSearchDto().builder()
                        .header("Audi")
                        .imageUrl("1.jpg")
                        .build(),
                new LastSearchDto().builder()
                        .header("Mers")
                        .imageUrl("2.jpg")
                        .build()
        );
    }
}
