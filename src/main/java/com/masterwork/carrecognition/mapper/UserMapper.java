package com.masterwork.carrecognition.mapper;

import com.masterwork.carrecognition.dto.UserDto;
import com.masterwork.carrecognition.model.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapper {

    private final ModelMapper mapper;

    public UserDto convertToDto(User user) {
        return mapper.map(user, UserDto.class);
    }
}
