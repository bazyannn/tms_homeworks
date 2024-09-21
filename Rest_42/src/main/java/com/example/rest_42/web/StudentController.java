package com.example.rest_42.web;

import com.example.rest_42.dto.StudentDto;
import com.example.rest_42.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor

public class StudentController {

    private final StudentService service;

    @GetMapping
    public List<StudentDto> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public StudentDto findById(@PathVariable(name = "id") UUID id) {
        return service.findById(id);
    }

    @PostMapping
    public StudentDto create (@RequestBody StudentDto dto) {
        return service.createStudent(dto);
    }

    @PutMapping("/{id}")
    public StudentDto update (@PathVariable(name = "id") UUID id,
                              @RequestBody StudentDto dto) {
        return service.update (id,dto);
    }

    @DeleteMapping("/{id}")
    public StudentDto delete (@PathVariable(name = "id") UUID id) {
        return service.delete(id);
    }

    @GetMapping("/search/{address}")
    public List<StudentDto> searchByAddress (@PathVariable String address) {
        return service.findStudentByAddressIgnoreCase(address);
    }
}
