package com.enoca.demo.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class StudentResponse {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private Date birthDate;
    private Set<CourseResponse> courseList;
}
