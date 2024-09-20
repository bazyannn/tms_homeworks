package com.example.rest_43_1.service;


import com.example.rest_43_1.dto.BicycleDto;
import com.example.rest_43_1.dto.PaginationDto;
import com.example.rest_43_1.dto.SearchDto;

import java.util.List;
import java.util.UUID;

public interface RentService {

    List<BicycleDto> findAll(PaginationDto dto);

    List<BicycleDto> search(SearchDto dto);

//    List<BicycleDto> searchForRent (SearchDto dto);   // 2 вариант поиска

    BicycleDto findById(UUID id);

}
