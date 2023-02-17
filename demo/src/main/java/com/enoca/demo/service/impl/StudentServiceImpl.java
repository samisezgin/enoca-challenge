package com.enoca.demo.service.impl;

import com.enoca.demo.dto.request.StudentRequest;
import com.enoca.demo.dto.response.StudentResponse;
import com.enoca.demo.model.Student;
import com.enoca.demo.repository.CourseRepository;
import com.enoca.demo.repository.StudentRepository;
import com.enoca.demo.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ResponseEntity<StudentResponse> getById(Integer id) {
        Student foundStudent = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        return ResponseEntity.ok(modelMapper.map(foundStudent, StudentResponse.class));
    }

    @Override
    public ResponseEntity<List<StudentResponse>> getAll() {
        var students = studentRepository.findAll().stream().map(student -> modelMapper.map(student, StudentResponse.class)).toList();
        return ResponseEntity.ok(students);
    }

    @Override
    public ResponseEntity<StudentResponse> add(StudentRequest studentRequest) {
        var student = studentRepository.save(modelMapper.map(studentRequest, Student.class));
        return ResponseEntity.ok(modelMapper.map(student, StudentResponse.class));
    }

    @Override
    public ResponseEntity<StudentResponse> update(Integer id, StudentRequest studentRequest) {

        var student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found with the id to update"));
        student.setName(studentRequest.getName());
        student.setSurname(studentRequest.getSurname());
        student.setBirthDate(studentRequest.getBirthDate());
        student.setEmail(studentRequest.getEmail());

        return ResponseEntity.ok(modelMapper.map(studentRepository.save(student), StudentResponse.class));
    }

    @Override
    public ResponseEntity<StudentResponse> delete(Integer id) {

        var student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found with the id to delete"));
        studentRepository.deleteById(id);
        return ResponseEntity.ok(modelMapper.map(student, StudentResponse.class));
    }

    @Override
    public ResponseEntity<StudentResponse> addCourse(Integer studentId, String courseCode) {
        var student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found with the id to add course"));
        var course = courseRepository.findByCourseCodeIgnoreCase(courseCode).orElseThrow(() -> new RuntimeException("Course not found with the code"));
        if (student.getCourseList() == null) {
            student.setCourseList(new HashSet<>());
        }
        student.getCourseList().add(course);
        return ResponseEntity.ok(modelMapper.map(studentRepository.save(student), StudentResponse.class));

    }
}
