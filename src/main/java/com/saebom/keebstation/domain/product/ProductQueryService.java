package com.saebom.keebstation.domain.product;

import com.saebom.keebstation.web.dto.api.product.ProductDetailResponse;

public interface ProductQueryService {
    ProductDetailResponse getProductDetail(Long productId);
}