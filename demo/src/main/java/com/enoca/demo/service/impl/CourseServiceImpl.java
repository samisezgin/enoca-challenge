package com.enoca.demo.service.impl;

import com.enoca.demo.dto.request.CourseRequest;
import com.enoca.demo.dto.response.CourseResponse;
import com.enoca.demo.exceptions.CourseNotFoundException;
import com.enoca.demo.model.Course;
import com.enoca.demo.repository.CourseRepository;
import com.enoca.demo.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public CourseServiceImpl(CourseRepository courseRepository, ModelMapper modelMapper) {
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<CourseResponse> getById(Integer id) {
        var foundCourse = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found with that id"));
        return ResponseEntity.ok(modelMapper.map(foundCourse, CourseResponse.class));
    }

    @Override
    public ResponseEntity<List<CourseResponse>> getAll() {
        var courses = courseRepository.findAll().stream().map(student -> modelMapper.map(student, CourseResponse.class)).toList();
        return ResponseEntity.ok(courses);
    }

    @Override
    public ResponseEntity<CourseResponse> add(CourseRequest courseRequest) {
        var course = courseRepository.save(modelMapper.map(courseRequest, Course.class));
        return ResponseEntity.ok(modelMapper.map(course, CourseResponse.class));
    }

    @Override
    public ResponseEntity<CourseResponse> update(Integer id, CourseRequest courseRequest) {

        var course = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course not found with that id to update"));
        course.setCourseName(courseRequest.getCourseName());
        course.setCourseCode(courseRequest.getCourseCode());

        return ResponseEntity.ok(modelMapper.map(courseRepository.save(course), CourseResponse.class));
    }

    @Override
    public ResponseEntity<CourseResponse> delete(Integer id) {

        var course = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course not found with that id to delete"));
        courseRepository.deleteById(id);
        return ResponseEntity.ok(modelMapper.map(course, CourseResponse.class));
    }
}
