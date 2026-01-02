package com.saebom.keebstation.domain.payment.dto;

import com.saebom.keebstation.domain.payment.PaymentMethod;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PayOrderRequest {

    private long amount;
    private PaymentMethod method;
}