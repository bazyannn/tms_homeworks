package com.example.rest_42.mapper;

import com.example.rest_42.domain.Student;
import com.example.rest_42.dto.StudentDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toEntity (StudentDto dto);

    StudentDto toDto (Student entity);

    List<StudentDto> toDto (List<Student> entities);
}
