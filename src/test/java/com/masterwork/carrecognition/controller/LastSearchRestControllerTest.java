package com.masterwork.carrecognition.controller;

import com.masterwork.carrecognition.controller.data.LastSearchRestControllerTestData;
import com.masterwork.carrecognition.dto.LastSearchDto;
import com.masterwork.carrecognition.mapper.LastSearchMapper;
import com.masterwork.carrecognition.model.LastSearch;
import com.masterwork.carrecognition.service.LastSearchService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LastSearchRestController.class)
public class LastSearchRestControllerTest extends LastSearchRestControllerTestData {

    @MockBean
    LastSearchService service;
    @MockBean
    LastSearchMapper mapper;
    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldGetAllFavouritesByUserId() throws Exception {
        List<LastSearch> lastSearches = generateLastSearches();
        List<LastSearchDto> lastSearchesDtoList = generateLastSearchesDto();
        when(service.getAllByUserId(1L)).thenReturn(lastSearches);
        when(mapper.convertToLastSearchDto(lastSearches.get(0))).thenReturn(lastSearchesDtoList.get(0));
        when(mapper.convertToLastSearchDto(lastSearches.get(1))).thenReturn(lastSearchesDtoList.get(1));

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/lastSearches/{id}", "1")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$[1].header", Matchers.is(lastSearchesDtoList.get(1).getHeader())));

    }


}
