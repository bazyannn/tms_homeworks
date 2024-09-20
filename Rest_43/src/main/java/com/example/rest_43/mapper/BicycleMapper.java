package com.example.rest_43.mapper;

import com.example.rest_43.domain.Bicycle;
import com.example.rest_43.dto.BicycleDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BicycleMapper {

    BicycleDto toDto(Bicycle bicycle);

    Bicycle toEntity(BicycleDto dto);

    List<BicycleDto> toDto(List<Bicycle> bicycles);

    void update(@MappingTarget Bicycle target, Bicycle source);

}
