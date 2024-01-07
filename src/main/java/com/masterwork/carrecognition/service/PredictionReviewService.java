package com.masterwork.carrecognition.service;

import com.masterwork.carrecognition.dto.PredictionReviewDto;
import com.masterwork.carrecognition.model.PredictionReview;

import java.util.List;

public interface PredictionReviewService {

    List<PredictionReview> getAll();

    List<PredictionReview> getAllByUserId(Long userId);

    void addPredictionReview(PredictionReviewDto predictionReviewDto);
}
