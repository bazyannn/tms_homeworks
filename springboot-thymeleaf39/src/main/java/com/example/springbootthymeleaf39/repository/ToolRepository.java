package com.example.springbootthymeleaf39.repository;

import com.example.springbootthymeleaf39.domain.ToolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


import java.util.UUID;

public interface ToolRepository extends JpaRepository<ToolEntity, UUID> {

    @Transactional
    @Modifying
    @Query(value = "update ToolEntity set deleted = true where id= :id")
    void deleteTool(UUID id);

    @Transactional
    @Modifying
    @Query(value = "update tools set deleted = false where id= :id", nativeQuery = true)
    void returnTool(UUID id);


}
