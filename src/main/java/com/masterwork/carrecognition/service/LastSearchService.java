package com.masterwork.carrecognition.service;

import com.masterwork.carrecognition.dto.LastSearchExtendedDto;
import com.masterwork.carrecognition.model.LastSearch;

import java.util.List;

public interface LastSearchService {

    List<LastSearch> getAllByUserId(Long userId);

    void addLastSearchToUser(LastSearchExtendedDto lastSearchExtendedDto);


}
