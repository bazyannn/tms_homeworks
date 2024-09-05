package com.example.springbootthymeleaf39.service.impl;

import com.example.springbootthymeleaf39.domain.ToolEntity;
import com.example.springbootthymeleaf39.dto.SearchDto;
import com.example.springbootthymeleaf39.dto.ToolDto;
import com.example.springbootthymeleaf39.mapper.ToolMapper;
import com.example.springbootthymeleaf39.repository.ToolRepository;
import com.example.springbootthymeleaf39.service.ToolService;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    public List<ToolDto> findAll(SearchDto dto) {
        return mapper.toDto(toolRepo.findAll(createSpecification(dto)));
    }

    @Override
    public ToolDto findById(UUID id) {
        Optional<ToolEntity> tool = toolRepo.findById(id);
        if (tool.isPresent()) {
            return mapper.toDto(tool.get());
        }
       return null;
    }

    @Override
    public void deleteTool(UUID id, Boolean deleted) {
        toolRepo.deleteTool(id, deleted);
    }

//    @Override
//    public void returnTool(UUID id, Boolean deleted) {
//        toolRepo.returnTool(id);
//    }

    private Specification<ToolEntity> createSpecification(SearchDto searchDto){
        return (root, query, criteriaBuilder) -> {
            ArrayList<Predicate> predicates = new ArrayList<>();

            String title = searchDto.getTitle();
            if (title !=null && !title.isEmpty()){
                Predicate titlePr = criteriaBuilder.like(root.get("title"), title);
                predicates.add(titlePr);
            }

            Integer costMoreThen = searchDto.getCostMoreThen();
            if (costMoreThen !=null){
                Predicate costPr = criteriaBuilder.greaterThan(root.get("cost"), costMoreThen);
                predicates.add(costPr);
            }

            Integer countLessThen = searchDto.getCountLessThen();
            if (countLessThen !=null) {
                Predicate countPr = criteriaBuilder.lessThan(root.get("count"), countLessThen);
                predicates.add(countPr);
            }

            Boolean isDelivered = searchDto.getIsDelivered();

            if ( isDelivered !=null && isDelivered == true) {
                Predicate isDeliveredPr = criteriaBuilder.equal(root.get("isDelivered").as(Boolean.class), isDelivered);
                predicates.add(isDeliveredPr);
            }
//            if ( isDelivered !=null) {
//                Predicate isDeliveredPr = criteriaBuilder.equal(root.get("isDelivered").as(Boolean.class), isDelivered);
//                predicates.add(isDeliveredPr);
//            }
             /*Сергей, подскажи пожалуйста. У меня получается поиск по двум значениям одновременно,
             когда не ставишь чекбокс о возможности(хотя выбираю другой критерий для поиска) доставки
             (потому что летит значение false в поле Boolean isDelivered у ToolEntity).
             Т.е. я не могу выбрать поиск только по названию товара(или только количество, или только стоимость) и всё.
             Как это можно исправить? */

            Predicate predicate = criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
            return predicate;
        };
    }
}
