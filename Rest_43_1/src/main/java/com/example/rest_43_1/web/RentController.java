package com.example.rest_43_1.web;

import com.example.rest_43_1.dto.BicycleDto;
import com.example.rest_43_1.dto.ErrorDto;
import com.example.rest_43_1.dto.PaginationDto;
import com.example.rest_43_1.dto.SearchDto;
import com.example.rest_43_1.service.RentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(tags = "rent",
            summary = "Find bicycle by ID",
            description = "find bicycle from DB by ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Bicycle was found",
                            content = @Content(
                                    mediaType = "application/application.json",
                                    schema = @Schema(
                                            implementation = BicycleDto.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bicycle not found",
                            content = @Content(
                                    mediaType = "application/application.json",
                                    schema = @Schema(
                                            implementation = ErrorDto.class
                                    )
                            )
                    )
            }
    )
    @GetMapping("/{id}")
    public BicycleDto findById(@PathVariable(name = "id") UUID id) {
        return service.findById(id);
    }

    @PostMapping("/search")
    public List<BicycleDto> searchRentBicycle(@RequestBody SearchDto dto) {
        return service.search(dto);
    }
}
