package com.example.demo.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class InputValidationFailedResponse {

    private int errorCode = 100;
    private int input;
    private String message;
}
