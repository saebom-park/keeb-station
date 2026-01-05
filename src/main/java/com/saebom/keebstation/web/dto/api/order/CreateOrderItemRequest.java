package com.saebom.keebstation.web.dto.api.order;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateOrderItemRequest {

    private Long productOptionId;
    private int quantity;
}