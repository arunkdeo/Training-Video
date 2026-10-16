package com.varahatech.addition.controllers;

import com.varahatech.addition.dto.AdditionRequestDTO;
import com.varahatech.addition.dto.AdditionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sum")
public class SumCalculator {

    @GetMapping
    public ResponseEntity<?> healthCheck() {
        return new ResponseEntity<>("Addition Service is up and running", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AdditionResponseDTO> addNumbers(@RequestBody AdditionRequestDTO request) {
        double sum = request.getAugend() + request.getAddend();
        var response = AdditionResponseDTO.builder()
                .addend(request.getAugend())
                .augend(request.getAddend())
                .sum(sum)
                .build();
        response.setOperation("Addition");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
