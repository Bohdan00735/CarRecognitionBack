package com.masterwork.carrecognition.controller;

import com.masterwork.carrecognition.controller.data.FavouriteRestControllerTestData;
import com.masterwork.carrecognition.dto.FavouriteDto;
import com.masterwork.carrecognition.mapper.FavouriteMapper;
import com.masterwork.carrecognition.model.Favourite;
import com.masterwork.carrecognition.service.FavouriteService;
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


@WebMvcTest(FavouriteRestController.class)
public class FavouriteRestControllerTest extends FavouriteRestControllerTestData {

    @MockBean
    FavouriteService service;
    @MockBean
    FavouriteMapper mapper;
    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldGetAllFavouritesByUserId() throws Exception {
        List<Favourite> favourites = generateFavourites();
        List<FavouriteDto> favouriteDtoList = generateFavoritesDto();
        when(service.getAllByUserId(1L)).thenReturn(favourites);
        when(mapper.convertToFavouriteDto(favourites.get(0))).thenReturn(favouriteDtoList.get(0));
        when(mapper.convertToFavouriteDto(favourites.get(1))).thenReturn(favouriteDtoList.get(1));

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/favourites/{id}", "1")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$[1].header", Matchers.is(favouriteDtoList.get(1).getHeader())));

    }

}
