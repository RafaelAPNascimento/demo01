package com.example.demo.controller;

import com.example.demo.dto.MultiplyRequest;
import com.example.demo.dto.Response;
import com.example.demo.exception.InputValidationException;
import com.example.demo.service.ReactiveMathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rx-math")
public class ReactiveMathController {

    @Autowired
    private ReactiveMathService reactiveMathService;

    @GetMapping("/square/{input}")
    public Mono<Response> square(@PathVariable int input) {
        return Mono.just(input)
                .handle((value, sink) -> {
                    if (value >= 10 && value <= 20)
                        sink.next(value);
                    else
                        sink.error(new InputValidationException(value));
                })
                .cast(Integer.class)
                .flatMap(i -> reactiveMathService.square(i));
    }

    @GetMapping(value = "/table/{input}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Response> table(@PathVariable int input) {
        return reactiveMathService.table(input);
    }

    @PostMapping("/multiply")
    public Mono<Response> multiply(@RequestBody Mono<MultiplyRequest> request) {
        return reactiveMathService.multiply(request);
    }
}
