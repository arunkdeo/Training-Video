package com.varahatech.subtraction.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SubtractionResponseDTO extends ResponseDTO {
    private double minuend;
    private double subtrahend;
    private double difference;
}
