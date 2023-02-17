package com.enoca.demo.dto.request;

import com.enoca.demo.model.Course;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class StudentRequest {
    private String name;
    private String surname;
    private String email;
    private Date birthDate;
}
