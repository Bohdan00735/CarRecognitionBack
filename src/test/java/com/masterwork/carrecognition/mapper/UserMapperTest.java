package com.masterwork.carrecognition.mapper;

import com.masterwork.carrecognition.config.TestConfig;
import com.masterwork.carrecognition.dto.UserDto;
import com.masterwork.carrecognition.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = UserMapper.class)
@ContextConfiguration(classes = TestConfig.class)
public class UserMapperTest {


    @Autowired
    UserMapper userMapper;

    @Test
    void shouldConvertToDto() {
        User user = new User(1L);
        UserDto expected = new UserDto(1L);
        UserDto actual = userMapper.convertToDto(user);
        assertEquals(expected, actual);

    }
}
