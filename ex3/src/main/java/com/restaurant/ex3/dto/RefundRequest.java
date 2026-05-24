package com.restaurant.ex3.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefundRequest {

    @Pattern(
            regexp = "^[A-Z0-9]+$",
            message = "Transaction code không hợp lệ"
    )
    private String transactionCode;

    @Positive
    private Double amount;
}