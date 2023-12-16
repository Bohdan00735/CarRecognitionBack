package com.masterwork.carrecognition.service;

import com.masterwork.carrecognition.model.Favourite;

import java.util.List;

public interface FavouriteService {

    List<Favourite> getAllByUserId(Long userId);

}
