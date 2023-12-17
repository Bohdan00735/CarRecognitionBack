package com.masterwork.carrecognition.controller;


import com.masterwork.carrecognition.dto.LastSearchDto;
import com.masterwork.carrecognition.mapper.LastSearchMapper;
import com.masterwork.carrecognition.service.LastSearchService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/lastSearches", produces = "application/json")
@AllArgsConstructor
public class LastSearchRestController {

    private final LastSearchService lastSearchService;
    private final LastSearchMapper lastSearchMapper;

    @GetMapping("/{id}")
    public ResponseEntity<List<LastSearchDto>> getLastSearches(@PathVariable("id") Long userId) {
        return ResponseEntity.ok(lastSearchService.getAllByUserId(userId).stream().map(lastSearchMapper::convertToLastSearchDto).collect(Collectors.toList()));
    }


}
