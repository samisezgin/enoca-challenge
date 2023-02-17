package com.enoca.demo.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class CourseResponse {
    private Integer id;
    private String courseCode;
    private String courseName;
    @JsonIgnore
    private Set<StudentResponse> studentList;
}
