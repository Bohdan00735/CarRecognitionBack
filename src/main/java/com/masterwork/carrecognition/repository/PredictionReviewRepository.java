package com.masterwork.carrecognition.repository;

import com.masterwork.carrecognition.model.PredictionReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PredictionReviewRepository extends JpaRepository<PredictionReview, Long> {

    List<PredictionReview> findAllByUserId(Long userId);

}
