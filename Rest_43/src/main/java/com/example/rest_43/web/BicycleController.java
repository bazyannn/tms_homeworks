package com.example.rest_43.web;

import com.example.rest_43.domain.Type;
import com.example.rest_43.dto.BicycleDto;
//import com.example.rest_43.dto.SearchDto;
import com.example.rest_43.dto.PaginationDto;
import com.example.rest_43.dto.SearchDto;
import com.example.rest_43.service.BicycleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bicycle")
@RequiredArgsConstructor
public class BicycleController {

    private final BicycleService service;

    @PostMapping("/all")
    public List<BicycleDto> getAll(@RequestBody PaginationDto dto) {
        return service.findAll(dto);
    }

    @GetMapping("/{id}")
    public BicycleDto getBicycleById(@PathVariable(name = "id") UUID id) {
        return service.findById(id);
    }

    @PostMapping
    public BicycleDto createBicycle(@RequestBody BicycleDto dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public BicycleDto updateBicycle(@RequestBody BicycleDto dto,
                                    @PathVariable(name = "id") UUID id) {
        return service.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public BicycleDto deleteBicycle(@PathVariable(name = "id") UUID id) {
        return service.delete(id);
    }

    @PostMapping("/search")
    public List<BicycleDto> search(@RequestBody SearchDto dto) {
        return service.search(dto);
    }
//    @PostMapping("/search/{producer}/{type}")                                          // 2 вариант поиска
//    public List<BicycleDto> search (@PathVariable(name = "producer") String producer,
//                                    @PathVariable(name = "type")Type type){
//        return service.findAll(producer,type);
//    }
}
