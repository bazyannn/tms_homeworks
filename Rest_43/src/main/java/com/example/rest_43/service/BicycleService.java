package com.example.rest_43.service;

import com.example.rest_43.domain.Type;
import com.example.rest_43.dto.BicycleDto;
import com.example.rest_43.dto.PaginationDto;
import com.example.rest_43.dto.SearchDto;

import java.util.List;
import java.util.UUID;

public interface BicycleService {

    List<BicycleDto> findAll(PaginationDto dto);

    List<BicycleDto> search(SearchDto dto);

//    List<BicycleDto> findAll( String producer, Type type);  // 2 вариант поиска

    BicycleDto findById(UUID id);

    BicycleDto save(BicycleDto dto);

    BicycleDto update(BicycleDto dto, UUID id);

    BicycleDto delete(UUID id);


}
