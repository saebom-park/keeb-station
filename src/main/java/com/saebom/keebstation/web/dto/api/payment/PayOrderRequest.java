package com.saebom.keebstation.web.dto.api.payment;

import com.saebom.keebstation.domain.payment.PaymentMethod;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PayOrderRequest {

    private long amount;
    private PaymentMethod method;
}