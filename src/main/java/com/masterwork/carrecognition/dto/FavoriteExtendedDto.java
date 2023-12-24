package com.masterwork.carrecognition.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteExtendedDto {


    public String header;
    public String imageUrl;
    public long userId;

}
