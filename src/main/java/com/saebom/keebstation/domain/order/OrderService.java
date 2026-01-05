package com.saebom.keebstation.domain.order;

import com.saebom.keebstation.web.dto.api.order.CreateOrderRequest;
import com.saebom.keebstation.web.dto.api.order.CreateOrderResponse;

public interface OrderService {

    CreateOrderResponse createOrder(Long memberId, CreateOrderRequest request);
    void cancelOrder(Long orderId);
}