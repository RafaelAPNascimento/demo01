package com.example.demo.exception.handler;

import com.example.demo.dto.InputValidationFailedResponse;
import com.example.demo.exception.InputValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InputValidationHandler {

    @ExceptionHandler(InputValidationException.class)
    public ResponseEntity<InputValidationFailedResponse> handle(InputValidationException exception) {
        InputValidationFailedResponse failedResponse = new InputValidationFailedResponse();
        failedResponse.setInput(exception.getInput());
        failedResponse.setMessage(exception.getMessage());
        return ResponseEntity.badRequest().body(failedResponse);
    }
}
