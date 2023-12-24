package com.masterwork.carrecognition.controller;

import com.masterwork.carrecognition.dto.UserDto;
import com.masterwork.carrecognition.mapper.UserMapper;
import com.masterwork.carrecognition.model.User;
import com.masterwork.carrecognition.service.UserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserRestController.class)
public class UserRestControllerTest {

    @MockBean
    UserService service;
    @MockBean
    UserMapper mapper;
    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldCreateUserAndReturnId() throws Exception {
        User user = new User(1L);
        UserDto userDto = new UserDto(1L);

        when(service.createUser()).thenReturn(user);
        when(mapper.convertToDto(user)).thenReturn(userDto);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/v1/users/create")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.id", Matchers.is(1)));

    }

}
