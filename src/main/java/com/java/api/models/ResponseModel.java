package com.java.api.models;



import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseModel<T> {
    private Date date;
    private int code;
    private String message;
    private T response;
}
