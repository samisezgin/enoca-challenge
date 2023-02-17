package com.enoca.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String msg) {
        super(msg);
    }
}
