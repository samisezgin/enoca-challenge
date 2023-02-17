package com.enoca.demo.controller;

import com.enoca.demo.dto.request.StudentRequest;
import com.enoca.demo.dto.response.StudentResponse;
import com.enoca.demo.service.impl.StudentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getById(@PathVariable Integer id) {
        return studentService.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAll() {
        return studentService.getAll();
    }

    @PostMapping
    public ResponseEntity<StudentResponse> create(@RequestBody StudentRequest studentRequest) {
        return studentService.add(studentRequest);
    }

    @PostMapping("/course")
    public ResponseEntity<StudentResponse> addCourse(@RequestParam Integer studentId, @RequestParam String courseCode) {
        return studentService.addCourse(studentId, courseCode);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> update(@PathVariable Integer id, @RequestBody StudentRequest studentRequest) {
        return studentService.update(id, studentRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentResponse> delete(@PathVariable Integer id) {
        return studentService.delete(id);
    }
}
