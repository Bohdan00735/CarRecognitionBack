package com.masterwork.carrecognition.service.impl;

import com.masterwork.carrecognition.dto.LastSearchExtendedDto;
import com.masterwork.carrecognition.model.LastSearch;
import com.masterwork.carrecognition.repository.LastSearchRepository;
import com.masterwork.carrecognition.repository.UserRepository;
import com.masterwork.carrecognition.service.LastSearchService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class LastSearchServiceImpl implements LastSearchService {

    private final LastSearchRepository lastSearchRepository;
    private final UserRepository userRepository;


    @Override
    @Transactional(readOnly = true)
    public List<LastSearch> getAllByUserId(Long userId) {
        log.info("Return all last searches by User id = " + userId);
        return lastSearchRepository.findAllByUserId(userId);
    }

    @Override
    @Transactional
    public void addLastSearchToUser(LastSearchExtendedDto lastSearchExtendedDto) {
        LastSearch lastSearch = new LastSearch().builder()
                .header(lastSearchExtendedDto.getHeader())
                .imageUrl(lastSearchExtendedDto.getImageUrl())
                .user(userRepository.findById(lastSearchExtendedDto.getUserId()).orElseThrow())
                .build();

        LastSearch saved = lastSearchRepository.save(lastSearch);
        log.info("LastSearch successful saved: " + saved);
    }
}
