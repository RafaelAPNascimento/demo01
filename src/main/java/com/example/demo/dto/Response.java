package com.example.demo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Response {

    private LocalDateTime time;
    private int result;

    public Response(int result) {
        this.result = result;
        this.time = LocalDateTime.now();
    }
}
