package com.restaurant.ex3.aspect;

import com.restaurant.ex3.annotation.RequireManagerApproval;
import com.restaurant.ex3.annotation.RequireOtp;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PaymentSecurityAspect {

    private final HttpServletRequest request;

    public PaymentSecurityAspect(HttpServletRequest request) {
        this.request = request;
    }

    @Before("@annotation(requireOtp)")
    public void verifyOtp(RequireOtp requireOtp) {

        String otp = request.getHeader("X-OTP");

        if (!"123456".equals(otp)) {
            throw new RuntimeException("OTP không hợp lệ");
        }
    }

    @Before("@annotation(requireManagerApproval)")
    public void verifyManager(
            RequireManagerApproval requireManagerApproval
    ) {

        String role = request.getHeader("X-Role");

        if (!"MANAGER".equals(role)) {
            throw new RuntimeException(
                    "Bạn không có quyền hoàn tiền"
            );
        }
    }
}