package com.example.springbootthymeleaf39.mapper;

import com.example.springbootthymeleaf39.domain.ToolEntity;
import com.example.springbootthymeleaf39.dto.ToolDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ToolMapper {

//    @Mapping(target = "deleted", constant = "false")
    ToolEntity toEntity (ToolDto dto);

    ToolDto toDto (ToolEntity entity);

    List<ToolDto> toDto (List<ToolEntity> entities);
}
