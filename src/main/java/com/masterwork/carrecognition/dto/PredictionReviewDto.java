package com.masterwork.carrecognition.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PredictionReviewDto {

    private String request;
    private boolean prediction;
    private String imageUrl;
    private String comment;
    private long userId;


}
