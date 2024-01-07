package com.masterwork.carrecognition.repository;

import com.masterwork.carrecognition.model.PredictionReview;
import com.masterwork.carrecognition.model.User;
import com.masterwork.carrecognition.repository.data.PredictionReviewRepositoryTestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class PredictionReviewRepositoryTest extends PredictionReviewRepositoryTestData {

    @Autowired
    PredictionReviewRepository predictionReviewRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    void shouldReadAndWritePredictionReview() {
        User user = userRepository.save(new User());
        PredictionReview toSave = generatePredictionReview(user);
        PredictionReview expected = predictionReviewRepository.save(toSave);
        Optional<PredictionReview> actual = predictionReviewRepository.findById(expected.getId());

        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());
    }

    @Test
    @Sql("/test_data_3.sql")
    void shouldFindAllByUserId() {
        User user = userRepository.findById(1L).orElseThrow();
        List<PredictionReview> actual = predictionReviewRepository.findAllByUserId(user.getId());
        assertEquals(2, actual.size());
    }
}
