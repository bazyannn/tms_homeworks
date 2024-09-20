package com.example.rest_43_1.client;

import com.example.rest_43_1.domain.Type;
import com.example.rest_43_1.dto.BicycleDto;
import com.example.rest_43_1.dto.PaginationDto;
import com.example.rest_43_1.dto.SearchDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Component
@FeignClient(name = "bicycleClient", url = "http://127.0.0.1:8081", path = "/bicycle")

public interface BicycleClient {

    @PostMapping("/all")
    List<BicycleDto> getAll(@RequestBody PaginationDto dto);

    @GetMapping("/{id}")
    BicycleDto getBicycleById(@PathVariable(name = "id") UUID id);

    @PostMapping("/search")
    List<BicycleDto> search(@RequestBody SearchDto dto);

//    @PostMapping("/search/{producer}/{type}")                                     // 2 вариант поиска
//    List<BicycleDto> search (@PathVariable(name = "producer") String producer,
//                                    @PathVariable(name = "type") Type type);
}
