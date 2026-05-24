package com.restaurant.ex3.controller;

import com.restaurant.ex3.dto.DomesticPaymentRequest;
import com.restaurant.ex3.dto.InternationalPaymentRequest;
import com.restaurant.ex3.dto.RefundRequest;
import com.restaurant.ex3.entity.Transaction;
import com.restaurant.ex3.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping("/domestic")
    public ResponseEntity<?> domesticPayment(
            @Valid @RequestBody DomesticPaymentRequest request
    ) {

        Transaction transaction =
                service.processDomesticPayment(request);

        return new ResponseEntity<>(
                transaction,
                HttpStatus.CREATED
        );
    }

    @PostMapping("/international")
    public ResponseEntity<?> internationalPayment(
            @Valid @RequestBody InternationalPaymentRequest request
    ) {

        Transaction transaction =
                service.processInternationalPayment(request);

        return new ResponseEntity<>(
                transaction,
                HttpStatus.CREATED
        );
    }

    @PostMapping("/refund")
    public ResponseEntity<?> refund(
            @Valid @RequestBody RefundRequest request
    ) {

        Transaction transaction =
                service.processRefund(request);

        return new ResponseEntity<>(
                transaction,
                HttpStatus.CREATED
        );
    }
}