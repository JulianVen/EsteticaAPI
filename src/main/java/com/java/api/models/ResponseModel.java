package com.java.api.models;



import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseModel<T> {
    private Date date;
    private int code;
    private String message;
    private T response;
}
