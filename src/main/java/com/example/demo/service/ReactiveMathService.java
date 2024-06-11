package com.example.demo.service;

import com.example.demo.dto.MultiplyRequest;
import com.example.demo.dto.Response;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@Log
public class ReactiveMathService {
    public Mono<Response> square(Integer input) {
        return Mono.fromSupplier(() -> input * input)
                .map(Response::new);
    }

    public Flux<Response> table(int input) {
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(this::log)
                .map(i -> new Response(i * input));
    }

    private void log(Integer value) {
        log.info("Math Service processing value " + value);
    }

    public Mono<Response> multiply(Mono<MultiplyRequest> request) {
        return request
                .map(req -> req.getN1() * req.getN2())
                .map(Response::new);


    }
}
