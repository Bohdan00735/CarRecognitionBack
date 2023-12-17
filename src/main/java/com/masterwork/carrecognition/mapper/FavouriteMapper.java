package com.masterwork.carrecognition.mapper;

import com.masterwork.carrecognition.dto.FavouriteDto;
import com.masterwork.carrecognition.model.Favourite;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FavouriteMapper {

    private final ModelMapper mapper;

    public FavouriteDto convertToFavouriteDto(Favourite favourite) {
        return mapper.map(favourite, FavouriteDto.class);
    }

}
