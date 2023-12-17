package com.masterwork.carrecognition.controller;

import com.masterwork.carrecognition.dto.FavouriteDto;
import com.masterwork.carrecognition.mapper.FavouriteMapper;
import com.masterwork.carrecognition.service.FavouriteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/favourites", produces = "application/json")
@AllArgsConstructor
public class FavouriteRestController {

    private final FavouriteService favouriteService;
    private final FavouriteMapper favouriteMapper;

    @GetMapping("/{id}")
    public ResponseEntity<List<FavouriteDto>> getFavourites(@PathVariable("id") Long userId) {
        return ResponseEntity.ok(favouriteService.getAllByUserId(userId).stream().map(favouriteMapper::convertToFavouriteDto).collect(Collectors.toList()));
    }


}
