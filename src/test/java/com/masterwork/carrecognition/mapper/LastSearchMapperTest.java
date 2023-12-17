package com.masterwork.carrecognition.mapper;

import com.masterwork.carrecognition.config.TestConfig;
import com.masterwork.carrecognition.dto.LastSearchDto;
import com.masterwork.carrecognition.model.LastSearch;
import com.masterwork.carrecognition.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = LastSearchMapper.class)
@ContextConfiguration(classes = TestConfig.class)
public class LastSearchMapperTest {

    @Autowired
    LastSearchMapper mapper;

    @Test
    void shouldConvertToDto() {
        LastSearch lastSearch = new LastSearch().builder()
                .id(1L)
                .header("header")
                .imageUrl("image")
                .user(new User(1L)).build();
        LastSearchDto expected = new LastSearchDto("header", "image");
        LastSearchDto actual = mapper.convertToLastSearchDto(lastSearch);
        assertEquals(expected, actual);
    }


}
