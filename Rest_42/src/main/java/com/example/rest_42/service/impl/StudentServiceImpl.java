package com.example.rest_42.service.impl;

import com.example.rest_42.domain.Student;
import com.example.rest_42.dto.StudentDto;
import com.example.rest_42.mapper.StudentMapper;
import com.example.rest_42.repository.StudentRepository;
import com.example.rest_42.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepo;
    private final StudentMapper mapper;
    @Override
    public List<StudentDto> findAll() {
        return mapper.toDto(studentRepo.findAll());
    }

    @Override
    public StudentDto findById(UUID id) {
        Optional<Student> byId = studentRepo.findById(id);
        if (byId.isPresent()){
            return mapper.toDto(byId.get());
        }
        return null;
    }

    @Override
    public StudentDto createStudent(StudentDto dto) {
        Student entity = mapper.toEntity(dto);
        Student save = studentRepo.save(entity);
        return mapper.toDto(save);
    }

    @Override
    public StudentDto update(UUID id, StudentDto dto) {
        Optional<Student> byId = studentRepo.findById(id);
        if (byId.isPresent()) {
            Student student = byId.get();

            student.setName(dto.getName());
            student.setSurname(dto.getSurname());
            student.setSex(dto.getSex());
            student.setYearOfBirthday(dto.getYearOfBirthday());
            student.setNumberOfClass(dto.getNumberOfClass());
            student.setAddress(dto.getAddress());

            Student update = studentRepo.save(student);

            return mapper.toDto(update);
        }
        return null;
    }

    @Override
    public StudentDto delete(UUID id) {
        Optional<Student> byId = studentRepo.findById(id);
        if(byId.isPresent()) {
            studentRepo.delete(byId.get());
            return mapper.toDto(byId.get());
        }
        return null;
    }

    @Override
    public List<StudentDto> findStudentByAddressIgnoreCase(String address) {
        return mapper.toDto(studentRepo.findStudentByAddressIgnoreCase(address));
    }
}
