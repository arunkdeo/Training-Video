package com.varahatech.addition.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AdditionResponseDTO extends ResponseDTO {
    private double augend;
    private double addend;
    private double sum;
}
