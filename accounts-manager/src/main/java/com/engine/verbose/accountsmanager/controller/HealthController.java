package com.engine.verbose.accountsmanager.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/")
public class HealthController {
    @GetMapping("/health")
    public ResponseEntity<Void> health() {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/actuator/health"));
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }
}
