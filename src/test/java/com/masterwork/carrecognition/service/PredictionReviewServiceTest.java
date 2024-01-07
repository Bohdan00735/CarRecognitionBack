package com.masterwork.carrecognition.service;

import com.masterwork.carrecognition.config.TestConfig;
import com.masterwork.carrecognition.dto.PredictionReviewDto;
import com.masterwork.carrecognition.model.PredictionReview;
import com.masterwork.carrecognition.model.User;
import com.masterwork.carrecognition.repository.PredictionReviewRepository;
import com.masterwork.carrecognition.repository.UserRepository;
import com.masterwork.carrecognition.service.impl.PredictionReviewServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = PredictionReviewServiceImpl.class)
@ContextConfiguration(classes = TestConfig.class)
public class PredictionReviewServiceTest {

    @MockBean
    PredictionReviewRepository predictionReviewRepository;
    @MockBean
    UserRepository userRepository;
    @Autowired
    PredictionReviewService predictionReviewService;

    @Test
    void shouldAddNewLastSearch() {

        PredictionReviewDto toSave = new PredictionReviewDto("Audi", true, "1.jog", "comm", 1L);
        User founded = new User(toSave.getUserId());

        PredictionReview predictionReview = new PredictionReview().builder()
                .request("Audi")
                .prediction(true)
                .imageUrl(toSave.getImageUrl())
                .comment("comm")
                .user(founded)
                .build();

        PredictionReview saved = new PredictionReview().builder()
                .id(1L)
                .request("Audi")
                .prediction(true)
                .imageUrl(toSave.getImageUrl())
                .comment("comm")
                .user(founded)
                .build();

        when(userRepository.findById(toSave.getUserId())).thenReturn(Optional.of(founded));
        when(predictionReviewRepository.save(predictionReview)).thenReturn(saved);

        predictionReviewService.addPredictionReview(toSave);
    }

}
