package com.example.demo.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MicroserviseBaseResponse {
    private boolean result;
    private String errorMessage;
    private int code; //httpCode
}
