package com.enoca.demo.service;

import com.enoca.demo.dto.request.CourseRequest;
import com.enoca.demo.dto.response.CourseResponse;
import com.enoca.demo.model.Course;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseService {
    ResponseEntity<CourseResponse> getById(Integer id);
    ResponseEntity<List<CourseResponse>> getAll();
    ResponseEntity<CourseResponse> add(CourseRequest courseRequest);
    ResponseEntity<CourseResponse> update(Integer id, CourseRequest courseRequest);
    ResponseEntity<CourseResponse> delete(Integer id);

}
