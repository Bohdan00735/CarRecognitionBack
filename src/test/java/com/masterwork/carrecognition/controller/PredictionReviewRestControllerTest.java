package com.masterwork.carrecognition.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.masterwork.carrecognition.controller.data.PredictionReviewRestControllerTestData;
import com.masterwork.carrecognition.dto.PredictionReviewDto;
import com.masterwork.carrecognition.mapper.PredictionReviewMapper;
import com.masterwork.carrecognition.model.PredictionReview;
import com.masterwork.carrecognition.service.PredictionReviewService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PredictionReviewRestController.class)
public class PredictionReviewRestControllerTest extends PredictionReviewRestControllerTestData {

    @MockBean
    PredictionReviewService service;
    @MockBean
    PredictionReviewMapper mapper;
    @Autowired
    MockMvc mockMvc;


    @Test
    void shouldGetAllPredictionReview() throws Exception {
        List<PredictionReview> predictionReviews = generateList();
        List<PredictionReviewDto> PredictionReviewDtoList = generateListDto();
        when(service.getAll()).thenReturn(predictionReviews);
        when(mapper.convertToDto(predictionReviews.get(0))).thenReturn(PredictionReviewDtoList.get(0));
        when(mapper.convertToDto(predictionReviews.get(1))).thenReturn(PredictionReviewDtoList.get(1));

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/predictionReviews")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$[1].request", Matchers.is(PredictionReviewDtoList.get(1).getRequest())));


    }

    @Test
    void shouldGetAllPredictionReviewByUser() throws Exception {
        List<PredictionReview> predictionReviews = generateList();
        List<PredictionReviewDto> PredictionReviewDtoList = generateListDto();
        when(service.getAllByUserId(1L)).thenReturn(predictionReviews);
        when(mapper.convertToDto(predictionReviews.get(0))).thenReturn(PredictionReviewDtoList.get(0));
        when(mapper.convertToDto(predictionReviews.get(1))).thenReturn(PredictionReviewDtoList.get(1));

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/predictionReviews/{id}", "1")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$[1].request", Matchers.is(PredictionReviewDtoList.get(1).getRequest())));


    }

    @Test
    void shouldAddPredictionReview() throws Exception {
        PredictionReviewDto predictionReviewDto = new PredictionReviewDto("Audi", true, "1.jog", "comm", 1L);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(predictionReviewDto);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/v1/predictionReviews/add")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json))
                .andExpect(status().isCreated());
        verify(service, times(1)).addPredictionReview(predictionReviewDto);
    }

}