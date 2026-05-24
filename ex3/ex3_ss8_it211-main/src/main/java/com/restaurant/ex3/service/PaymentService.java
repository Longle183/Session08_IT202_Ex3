package com.restaurant.ex3.service;

import com.restaurant.ex3.annotation.RequireManagerApproval;
import com.restaurant.ex3.annotation.RequireOtp;
import com.restaurant.ex3.dto.DomesticPaymentRequest;
import com.restaurant.ex3.dto.InternationalPaymentRequest;
import com.restaurant.ex3.dto.RefundRequest;
import com.restaurant.ex3.entity.Transaction;
import com.restaurant.ex3.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final TransactionRepository repository;

    public PaymentService(TransactionRepository repository) {
        this.repository = repository;
    }

    public Transaction processDomesticPayment(
            DomesticPaymentRequest request
    ) {

        Transaction transaction = new Transaction();

        transaction.setAmount(request.getAmount());
        transaction.setCurrency(request.getCurrency());
        transaction.setType("DOMESTIC");

        return repository.save(transaction);
    }

    @RequireOtp
    public Transaction processInternationalPayment(
            InternationalPaymentRequest request
    ) {

        Transaction transaction = new Transaction();

        transaction.setAmount(request.getAmount());
        transaction.setCurrency(request.getCurrency());
        transaction.setType("INTERNATIONAL");

        return repository.save(transaction);
    }

    @RequireManagerApproval
    public Transaction processRefund(
            RefundRequest request
    ) {

        Transaction transaction = new Transaction();

        transaction.setTransactionCode(
                request.getTransactionCode()
        );

        transaction.setAmount(request.getAmount());

        transaction.setType("REFUND");

        return repository.save(transaction);
    }
}