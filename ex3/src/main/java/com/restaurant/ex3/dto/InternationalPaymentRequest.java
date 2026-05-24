package com.restaurant.ex3.dto;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InternationalPaymentRequest {

    @Positive
    private Double amount;

    private String currency;
}