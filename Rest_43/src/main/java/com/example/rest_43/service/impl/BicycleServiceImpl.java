package com.example.rest_43.service.impl;

import com.example.rest_43.domain.Bicycle;
import com.example.rest_43.domain.Type;
import com.example.rest_43.dto.BicycleDto;
import com.example.rest_43.dto.PaginationDto;
import com.example.rest_43.dto.SearchDto;
import com.example.rest_43.exc.BicycleServiceException;
import com.example.rest_43.mapper.BicycleMapper;
import com.example.rest_43.repository.BicycleRepository;
import com.example.rest_43.service.BicycleService;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor

public class BicycleServiceImpl implements BicycleService {

    private final BicycleRepository bicycleRepo;
    private final BicycleMapper mapper;

    @Override
    public List<BicycleDto> findAll(PaginationDto dto) {
        Integer page = dto.getPage();
        Integer size = dto.getSize();
        if (page == null || page < 0) {
            page = 0;
        }
        if (size == null || size < 1) {
            size = 20;
        }

        PageRequest pageRequest = PageRequest.of(page, size);
        List<Bicycle> allByIsBusyFalse = bicycleRepo.findAllByIsBusy(false, pageRequest);

        return mapper.toDto(allByIsBusyFalse);
    }

    @Override
    public List<BicycleDto> search(SearchDto dto) {
        return mapper.toDto(bicycleRepo.findAll(createSpecification(dto))
                .stream()
                .filter(bicycle -> !bicycle.getIsBusy())
                .toList());
    }

//    @Override
//    public List<BicycleDto> findAll(String producer, Type type) {                 // 2 вариант поиска
//        return mapper.toDto(bicycleRepo.findByProducerOrType(producer, type))
//        .stream().filter(b -> !b.getIsBusy()).toList();
//    }

    @Override
    public BicycleDto findById(UUID id) {
        Optional<Bicycle> byId = bicycleRepo.findById(id);
        if (byId.isPresent()) {
            return mapper.toDto(byId.get());
        }
        throw new BicycleServiceException(404, "Bicycle not found");
    }

    @Override
    public BicycleDto save(BicycleDto dto) {
        Bicycle entity = mapper.toEntity(dto);
        bicycleRepo.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    @Transactional
    public BicycleDto update(BicycleDto dto, UUID id) {
        Bicycle entity = mapper.toEntity(dto);
        Optional<Bicycle> bicycleOp = bicycleRepo.findById(id);
        if (bicycleOp.isEmpty()) {
            throw new BicycleServiceException(404, "Bicycle not found");
        }
        Bicycle exist = bicycleOp.get();
        mapper.update(exist, entity);

        return mapper.toDto(exist);
    }

    @Override
    public BicycleDto delete(UUID id) {
        Optional<Bicycle> byId = bicycleRepo.findById(id);
        if (byId.isPresent()) {
            bicycleRepo.delete(byId.get());
            return mapper.toDto(byId.get());
        }
        throw new BicycleServiceException(404, "Bicycle not found");
    }

    private Specification<Bicycle> createSpecification(SearchDto searchDto) {
        return (root, query, criteriaBuilder) -> {
            ArrayList<Predicate> predicates = new ArrayList<>();

            String producer = searchDto.getProducerOfBicycle();
            if (producer != null && !producer.isEmpty()) {
                Predicate producerPr = criteriaBuilder.like(root.get("producer"), producer);
                predicates.add(producerPr);
            }

            Type typeOfBicycle = searchDto.getTypeOfBicycle();
            if (typeOfBicycle != null) {
                Predicate typePr = criteriaBuilder.equal(root.get("type"), typeOfBicycle);
                predicates.add(typePr);
            }

            Predicate predicate = criteriaBuilder.or(predicates.toArray(new Predicate[]{}));
            return predicate;
        };
    }
}
