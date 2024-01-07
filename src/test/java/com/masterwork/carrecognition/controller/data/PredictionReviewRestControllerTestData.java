package com.masterwork.carrecognition.controller.data;

import com.masterwork.carrecognition.dto.PredictionReviewDto;
import com.masterwork.carrecognition.model.PredictionReview;
import com.masterwork.carrecognition.model.User;

import java.util.Arrays;
import java.util.List;

public class PredictionReviewRestControllerTestData {

    protected List<PredictionReview> generateList() {
        return Arrays.asList(
                PredictionReview.builder()
                        .id(1L)
                        .request("Audi")
                        .prediction(true)
                        .imageUrl("1,jog")
                        .comment("comment")
                        .user(new User(1L))
                        .build(),
                PredictionReview.builder()
                        .id(2L)
                        .request("Audi")
                        .prediction(false)
                        .imageUrl("2,jog")
                        .comment("comment")
                        .user(new User(1L))
                        .build());
    }

    protected List<PredictionReviewDto> generateListDto() {
        return Arrays.asList(
                PredictionReviewDto.builder()
                        .request("Audi")
                        .prediction(true)
                        .imageUrl("1,jog")
                        .comment("comment")
                        .userId(1)
                        .build(),
                PredictionReviewDto.builder()
                        .request("Audi")
                        .prediction(false)
                        .imageUrl("2,jog")
                        .comment("comment")
                        .userId(2)
                        .build());
    }
}
