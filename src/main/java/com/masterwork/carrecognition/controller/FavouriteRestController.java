package com.masterwork.carrecognition.controller;

import com.masterwork.carrecognition.dto.FavoriteExtendedDto;
import com.masterwork.carrecognition.dto.FavouriteDto;
import com.masterwork.carrecognition.mapper.FavouriteMapper;
import com.masterwork.carrecognition.service.FavouriteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/favourites", produces = "application/json")
@AllArgsConstructor
public class FavouriteRestController {

    private final FavouriteService favouriteService;
    private final FavouriteMapper favouriteMapper;

    @Operation(summary = "Get list of favourites")
    @ApiResponse(responseCode = "200", description = "Received favourites from user",
            content = {@Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = FavouriteDto.class)))})
    @Parameter(name = "id", description = "User id")
    @GetMapping("/{id}")
    public ResponseEntity<List<FavouriteDto>> getFavourites(@PathVariable("id") Long userId) {
        return ResponseEntity.ok(favouriteService.getAllByUserId(userId).stream().map(favouriteMapper::convertToFavouriteDto).collect(Collectors.toList()));
    }

    @Operation(summary = "Add favourite")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Favourite added", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid data",
                    content = @Content)})
    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addFavourite(@RequestBody FavoriteExtendedDto favoriteExtendedDto) {
        favouriteService.addFavouriteToUser(favoriteExtendedDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
