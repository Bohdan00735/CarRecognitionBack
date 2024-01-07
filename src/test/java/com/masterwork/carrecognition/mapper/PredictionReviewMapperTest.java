package com.masterwork.carrecognition.mapper;

import com.masterwork.carrecognition.config.TestConfig;
import com.masterwork.carrecognition.dto.PredictionReviewDto;
import com.masterwork.carrecognition.model.PredictionReview;
import com.masterwork.carrecognition.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = PredictionReviewMapper.class)
@ContextConfiguration(classes = TestConfig.class)
public class PredictionReviewMapperTest {

    @Autowired
    PredictionReviewMapper predictionReviewMapper;


    @Test
    void shouldConvertToDto() {
        PredictionReview toMap = new PredictionReview(1L, "Audi", true, "1,jog", "comment", new User(1L));
        PredictionReviewDto expected = new PredictionReviewDto("Audi", true, "1,jog", "comment", 1);
        PredictionReviewDto actual = predictionReviewMapper.convertToDto(toMap);
        assertEquals(expected, actual);
    }

    @Test
    void shouldConvertToObject() {
        PredictionReviewDto toMap = new PredictionReviewDto("Audi", true, "1,jog", "comment", 1);
        PredictionReview expected = PredictionReview.builder().request("Audi").prediction(true).imageUrl("1,jog").comment("comment").user(new User(1L)).build();
        PredictionReview actual = predictionReviewMapper.convertToObject(toMap);
        assertEquals(expected, actual);
    }
}
