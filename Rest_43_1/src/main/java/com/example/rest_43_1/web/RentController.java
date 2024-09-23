package com.example.rest_43_1.web;

import com.example.rest_43_1.dto.BicycleDto;
import com.example.rest_43_1.dto.PaginationDto;
import com.example.rest_43_1.dto.SearchDto;
import com.example.rest_43_1.service.RentService;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rent")
@RequiredArgsConstructor
public class RentController {

    private final RentService service;

    @PostMapping("/all")
    public List<BicycleDto> findAllRent(@RequestBody PaginationDto dto) {
        return service.findAll(dto);
    }

    @GetMapping("/{id}")
    public BicycleDto findById(@PathVariable(name = "id") UUID id) {
        return service.findById(id);
    }

    @PostMapping("/search")
    public List<BicycleDto> searchRentBicycle(@RequestBody SearchDto dto) {
        return service.search(dto);
    }
}
