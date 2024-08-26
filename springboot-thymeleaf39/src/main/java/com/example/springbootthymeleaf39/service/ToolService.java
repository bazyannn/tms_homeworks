package com.example.springbootthymeleaf39.service;

import com.example.springbootthymeleaf39.dto.ToolDto;

import java.util.List;
import java.util.UUID;

public interface ToolService {

    void returnTool(UUID id);

    void deleteTool(UUID id);


    ToolDto findById(UUID id);

    void createTool (ToolDto tool );// использовал как для создания записи о товаре, так и для редактирования

    List<ToolDto> findAll();

}
