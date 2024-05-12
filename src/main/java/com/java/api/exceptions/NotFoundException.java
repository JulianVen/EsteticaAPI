package com.java.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Data;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Data
public class NotFoundException extends RuntimeException {

    private String object;

    public NotFoundException(String object) {
        super(String.format("%s not found", object));
        this.object = object;
    }

}
