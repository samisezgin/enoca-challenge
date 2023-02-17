package com.enoca.demo.service;

import com.enoca.demo.dto.request.CourseRequest;
import com.enoca.demo.dto.request.StudentRequest;
import com.enoca.demo.dto.response.CourseResponse;
import com.enoca.demo.dto.response.StudentResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    ResponseEntity<StudentResponse> getById(Integer id);
    ResponseEntity<List<StudentResponse>> getAll();
    ResponseEntity<StudentResponse> add(StudentRequest studentRequest);
    ResponseEntity<StudentResponse> update(Integer id, StudentRequest studentRequest);
    ResponseEntity<StudentResponse> delete(Integer id);

    ResponseEntity<StudentResponse> addCourse(Integer studentId, String courseCode);
}
