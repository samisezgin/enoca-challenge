package com.enoca.demo.controller;

import com.enoca.demo.dto.request.CourseRequest;
import com.enoca.demo.dto.request.StudentRequest;
import com.enoca.demo.dto.response.CourseResponse;
import com.enoca.demo.dto.response.StudentResponse;
import com.enoca.demo.service.impl.CourseServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseServiceImpl courseService;

    public CourseController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse> getById(@PathVariable Integer id) {
        return courseService.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<CourseResponse>> getAll() {
        return courseService.getAll();
    }

    @PostMapping
    public ResponseEntity<CourseResponse> create(@RequestBody CourseRequest courseRequest)
    {
        return courseService.add(courseRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseResponse> update(@PathVariable Integer id, CourseRequest courseRequest) {
        return courseService.update(id, courseRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CourseResponse> delete(@PathVariable Integer id) {
        return courseService.delete(id);
    }
}
