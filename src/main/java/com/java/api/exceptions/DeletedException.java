package com.java.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Data;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Data
public class DeletedException extends RuntimeException {
    private int identifier;

    public DeletedException(int identifier) {
        super(String.format("Service with ID %s was deleted", identifier));
        this.identifier = identifier;
    }
}
