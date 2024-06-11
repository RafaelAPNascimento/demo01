package com.example.demo.exception;

public class InputValidationException extends RuntimeException {

    private static final String MESSAGE = "Allowed range is 10 - 20";
    private static final int ERROR_CODE = 100;
    private final int input;

    public InputValidationException(int input) {
        super(MESSAGE);
        this.input = input;
    }

    public int getInput() {
        return input;
    }

    public static int getErrorCode() {
        return ERROR_CODE;
    }
}
