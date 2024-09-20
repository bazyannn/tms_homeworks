package com.example.rest_43.repository;

import com.example.rest_43.domain.Bicycle;
import com.example.rest_43.domain.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface BicycleRepository extends JpaRepository<Bicycle, UUID>, JpaSpecificationExecutor<Bicycle> {


    List<Bicycle> findByProducerOrType(String producer, Type type);  // 2 вариант поиска

    List<Bicycle> findAllByIsBusy(Boolean isBusy, Pageable pageable);
}
