package com.example.springbootthymeleaf39.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchDto {

    private String title;
    private Integer costMoreThen;
    private Integer countLessThen;
    private Boolean isDelivered;
}
