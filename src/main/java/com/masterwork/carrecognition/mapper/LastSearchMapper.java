package com.masterwork.carrecognition.mapper;

import com.masterwork.carrecognition.dto.LastSearchDto;
import com.masterwork.carrecognition.model.LastSearch;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LastSearchMapper {

    private final ModelMapper mapper;

    public LastSearchDto convertToLastSearchDto(LastSearch lastSearch) {
        return mapper.map(lastSearch, LastSearchDto.class);
    }
}
