package com.josh.backend_solution.controllers;

import com.josh.backend_solution.dtos.response.HealthResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/health")
public class HealthController {
    @GetMapping("/check")
    public ResponseEntity<HealthResponse> checkHealth() {
        HealthResponse healthResponse = new HealthResponse("OK", "The EPL Stats API is up and running normally.");
        return new ResponseEntity<>(healthResponse, HttpStatus.OK);
    }
}
