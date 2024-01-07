package com.masterwork.carrecognition.controller;


import com.masterwork.carrecognition.dto.LastSearchDto;
import com.masterwork.carrecognition.dto.LastSearchExtendedDto;
import com.masterwork.carrecognition.mapper.LastSearchMapper;
import com.masterwork.carrecognition.service.LastSearchService;
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
@RequestMapping(path = "/api/v1/lastSearches", produces = "application/json")
@AllArgsConstructor
public class LastSearchRestController {

    private final LastSearchService lastSearchService;
    private final LastSearchMapper lastSearchMapper;

    @Operation(summary = "Get list of last searches")
    @ApiResponse(responseCode = "200", description = "Received last searches from user",
            content = {@Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = LastSearchDto.class)))})
    @Parameter(name = "id", description = "User id")
    @Parameter(name = "count", description = "Count of searches")
    @GetMapping("/{id}")
    public ResponseEntity<List<LastSearchDto>> getLastSearches(@PathVariable("id") Long userId, @RequestParam(defaultValue = "5") int count) {
        return ResponseEntity.ok(lastSearchService.getAllLastByUserId(userId, count).stream().map(lastSearchMapper::convertToLastSearchDto).collect(Collectors.toList()));
    }

    @Operation(summary = "Add last search")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Last search added", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid data",
                    content = @Content)})
    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addLastSearch(@RequestBody LastSearchExtendedDto lastSearchExtendedDto) {
        lastSearchService.addLastSearchToUser(lastSearchExtendedDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
