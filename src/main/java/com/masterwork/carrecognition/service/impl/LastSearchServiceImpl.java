package com.masterwork.carrecognition.service.impl;

import com.masterwork.carrecognition.model.LastSearch;
import com.masterwork.carrecognition.repository.LastSearchRepository;
import com.masterwork.carrecognition.service.LastSearchService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class LastSearchServiceImpl implements LastSearchService {

    private final LastSearchRepository lastSearchRepository;

    @Override
    public List<LastSearch> getAllByUserId(Long userId) {
        log.info("Return all last searches by User id = " + userId);
        return lastSearchRepository.findAllByUserId(userId);
    }
}
