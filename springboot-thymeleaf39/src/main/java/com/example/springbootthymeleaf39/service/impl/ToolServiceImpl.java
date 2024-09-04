package com.example.springbootthymeleaf39.service.impl;

import com.example.springbootthymeleaf39.domain.ToolEntity;
import com.example.springbootthymeleaf39.dto.ToolDto;
import com.example.springbootthymeleaf39.mapper.ToolMapper;
import com.example.springbootthymeleaf39.repository.ToolRepository;
import com.example.springbootthymeleaf39.service.ToolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service

public class ToolServiceImpl implements ToolService {

    private final ToolRepository toolRepo;
    private final ToolMapper mapper;
    @Override
    public void createTool(ToolDto tool) {         // использовал как для создания записи о товаре, так и для редактирования
        toolRepo.save(mapper.toEntity(tool));
    }

    @Override
    public List<ToolDto> findAll() {
        return mapper.toDto(toolRepo.findAll());
    }

    @Override
    public ToolDto findById(UUID id) {
        ToolEntity entity = toolRepo.findById(id).get();
        return mapper.toDto(entity);
    }

    @Override
    public void deleteTool(UUID id) {
        toolRepo.deleteTool(id);
    }

    @Override
    public void returnTool(UUID id) {
        toolRepo.returnTool(id);
    }
}
