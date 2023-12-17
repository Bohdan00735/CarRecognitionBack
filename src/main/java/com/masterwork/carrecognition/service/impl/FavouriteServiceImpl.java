package com.masterwork.carrecognition.service.impl;

import com.masterwork.carrecognition.model.Favourite;
import com.masterwork.carrecognition.repository.FavouriteRepository;
import com.masterwork.carrecognition.service.FavouriteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class FavouriteServiceImpl implements FavouriteService {

    private final FavouriteRepository favouriteRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Favourite> getAllByUserId(Long userId) {
        log.info("Return all favorites by User id = " + userId);
        return favouriteRepository.findAllByUserId(userId);
    }
}
