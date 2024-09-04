package com.example.springbootthymeleaf39.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ToolDto {

    private UUID id;
    private String title;
    private Integer cost;
    private Integer count;
    private Boolean isDelivered;
    private Boolean deleted;
}
