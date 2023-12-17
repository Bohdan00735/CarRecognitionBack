package com.masterwork.carrecognition.mapper;

import com.masterwork.carrecognition.config.TestConfig;
import com.masterwork.carrecognition.dto.FavouriteDto;
import com.masterwork.carrecognition.model.Favourite;
import com.masterwork.carrecognition.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = FavouriteMapper.class)
@ContextConfiguration(classes = TestConfig.class)
public class FavouriteMapperTest {

    @Autowired
    FavouriteMapper mapper;

    @Test
    void shouldConvertToDto() {
        Favourite favourite = new Favourite().builder()
                .id(1L)
                .header("header")
                .imageUrl("image")
                .user(new User(1L)).build();
        FavouriteDto expected = new FavouriteDto("header", "image");
        FavouriteDto actual = mapper.convertToFavouriteDto(favourite);
        assertEquals(expected, actual);
    }
}
