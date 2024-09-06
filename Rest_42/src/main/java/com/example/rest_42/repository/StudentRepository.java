package com.example.rest_42.repository;

import com.example.rest_42.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {

    List<Student> findStudentByAddressIgnoreCase (String address);
}
