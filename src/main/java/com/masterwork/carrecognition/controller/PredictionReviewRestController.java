package com.masterwork.carrecognition.controller;

import com.masterwork.carrecognition.dto.PredictionReviewDto;
import com.masterwork.carrecognition.mapper.PredictionReviewMapper;
import com.masterwork.carrecognition.service.PredictionReviewService;
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

@RestController
@RequestMapping(path = "/api/v1/predictionReviews", produces = "application/json")
@AllArgsConstructor
public class PredictionReviewRestController {

    private final PredictionReviewMapper predictionReviewMapper;
    private final PredictionReviewService predictionReviewService;

    @Operation(summary = "Get list of all prediction reviews")
    @ApiResponse(responseCode = "200", description = "Received all prediction review",
            content = {@Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = PredictionReviewDto.class)))})
    @GetMapping
    public ResponseEntity<List<PredictionReviewDto>> getAllPredictionReviews() {
        return ResponseEntity.ok(predictionReviewService.getAll().stream().map(predictionReviewMapper::convertToDto).toList());
    }

    @Operation(summary = "Get list of all user's prediction reviews")
    @ApiResponse(responseCode = "200", description = "Received all user's prediction review",
            content = {@Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = PredictionReviewDto.class)))})
    @Parameter(name = "id", description = "User id")
    @GetMapping("/{id}")
    public ResponseEntity<List<PredictionReviewDto>> getAllPredictionReviewsByUser(@PathVariable("id") Long userId) {
        return ResponseEntity.ok(predictionReviewService.getAllByUserId(userId).stream().map(predictionReviewMapper::convertToDto).toList());
    }

    @Operation(summary = "Add prediction review")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Prediction review added", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid data",
                    content = @Content)})
    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addLastSearch(@RequestBody PredictionReviewDto predictionReviewDto) {
        predictionReviewService.addPredictionReview(predictionReviewDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
