package com.saebom.keebstation.web;

import com.saebom.keebstation.domain.payment.PaymentService;
import com.saebom.keebstation.domain.payment.dto.PayOrderRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders/{orderId}/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<Void> pay(
            @PathVariable Long orderId,
            @RequestBody PayOrderRequest request
    ) {
        paymentService.pay(orderId, request.getAmount(), request.getMethod());
        return ResponseEntity.ok().build();
    }
}