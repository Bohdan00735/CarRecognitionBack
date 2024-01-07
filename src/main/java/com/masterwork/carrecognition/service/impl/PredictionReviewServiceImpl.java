package com.masterwork.carrecognition.service.impl;

import com.masterwork.carrecognition.dto.PredictionReviewDto;
import com.masterwork.carrecognition.model.PredictionReview;
import com.masterwork.carrecognition.repository.PredictionReviewRepository;
import com.masterwork.carrecognition.repository.UserRepository;
import com.masterwork.carrecognition.service.PredictionReviewService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class PredictionReviewServiceImpl implements PredictionReviewService {

    private final UserRepository userRepository;
    private final PredictionReviewRepository predictionReviewRepository;

    @Override
    @Transactional(readOnly = true)
    public List<PredictionReview> getAll() {
        return predictionReviewRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PredictionReview> getAllByUserId(Long userId) {
        return predictionReviewRepository.findAllByUserId(userId);
    }

    @Override
    @Transactional
    public void addPredictionReview(PredictionReviewDto predictionReviewDto) {
        PredictionReview predictionReview = PredictionReview.builder()
                .request(predictionReviewDto.getRequest())
                .prediction(predictionReviewDto.isPrediction())
                .imageUrl(predictionReviewDto.getImageUrl())
                .comment(predictionReviewDto.getComment())
                .user(userRepository.findById(predictionReviewDto.getUserId()).orElseThrow())
                .build();
        predictionReviewRepository.save(predictionReview);
    }
}
