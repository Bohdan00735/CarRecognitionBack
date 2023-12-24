package com.masterwork.carrecognition.controller;

import com.masterwork.carrecognition.dto.UserDto;
import com.masterwork.carrecognition.mapper.UserMapper;
import com.masterwork.carrecognition.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/users", produces = "application/json")
@AllArgsConstructor
public class UserRestController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Operation(summary = "Create user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid data",
                    content = @Content)})
    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser() {
        return ResponseEntity.ok(userMapper.convertToDto(userService.createUser()));
    }
}
