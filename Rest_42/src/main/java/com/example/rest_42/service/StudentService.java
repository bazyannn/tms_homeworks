package com.example.rest_42.service;

import com.example.rest_42.domain.Student;
import com.example.rest_42.dto.StudentDto;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    List<StudentDto> findAll ();

    StudentDto findById (UUID id);

    StudentDto createStudent (StudentDto dto);

    List<StudentDto> findStudentByAddressIgnoreCase (String address);

    StudentDto update(UUID id, StudentDto dto);

    StudentDto delete(UUID id);
}
