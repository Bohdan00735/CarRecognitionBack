package com.masterwork.carrecognition.mapper;

import com.masterwork.carrecognition.dto.PredictionReviewDto;
import com.masterwork.carrecognition.model.PredictionReview;
import com.masterwork.carrecognition.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PredictionReviewMapper {

    public PredictionReviewDto convertToDto(PredictionReview predictionReview) {
        return new PredictionReviewDto().builder()
                .request(predictionReview.getRequest())
                .prediction(predictionReview.getPrediction())
                .imageUrl(predictionReview.getImageUrl())
                .comment(predictionReview.getComment())
                .userId(predictionReview.getUser().getId())
                .build();
    }

    public PredictionReview convertToObject(PredictionReviewDto predictionReviewDto) {
        return new PredictionReview().builder()
                .request(predictionReviewDto.getRequest())
                .prediction(predictionReviewDto.isPrediction())
                .imageUrl(predictionReviewDto.getImageUrl())
                .comment(predictionReviewDto.getComment())
                .user(new User(predictionReviewDto.getUserId()))
                .build();
    }
}
