package com.masterwork.carrecognition.repository.data;

import com.masterwork.carrecognition.model.PredictionReview;
import com.masterwork.carrecognition.model.User;

public class PredictionReviewRepositoryTestData {

    protected PredictionReview generatePredictionReview(User user) {
        return new PredictionReview().builder()
                .prediction(true)
                .request("Audi")
                .comment("check")
                .imageUrl("1.jpg")
                .user(user)
                .build();
    }


}
