package com.varahatech.subtraction.controller;

import com.varahatech.subtraction.dto.SubtractionRequestDTO;
import com.varahatech.subtraction.dto.SubtractionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subtract")
public class SubtractionController {

    @GetMapping("")
    public ResponseEntity<?> healthCheck() {
        return new ResponseEntity<>("Subtraction Service is up and running", HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<SubtractionResponseDTO> subtractNumber(@RequestBody SubtractionRequestDTO request) {
        var diff = request.getMinuend() - request.getSubtrahend();
        var response = SubtractionResponseDTO.builder()
                .minuend(request.getMinuend())
                .subtrahend(request.getSubtrahend())
                .difference(diff).build();
        response.setOperation("Subtraction");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
