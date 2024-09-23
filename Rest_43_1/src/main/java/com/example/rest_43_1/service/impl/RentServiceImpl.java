package com.example.rest_43_1.service.impl;

import com.example.rest_43_1.client.BicycleClient;
import com.example.rest_43_1.dto.BicycleDto;
import com.example.rest_43_1.dto.PaginationDto;
import com.example.rest_43_1.dto.SearchDto;
import com.example.rest_43_1.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RentServiceImpl implements RentService {

    private final BicycleClient client;

    @Override
    public List<BicycleDto> findAll(PaginationDto dto) {
        return client.getAll(dto);
    }

    @Override
    public List<BicycleDto> search(SearchDto dto) {
        return client.search(dto);
    }

//    @Override
//    public List<BicycleDto> searchForRent(SearchDto dto) {                             // 2 вариант поиска
//        return client.search(dto.getProducerOfBicycle(), dto.getTypeOfBicycle());
//    }

    @Override
    public BicycleDto findById(UUID id) {
        return client.getBicycleById(id);
    }
}
