package com.saebom.keebstation.web.api;

import com.saebom.keebstation.domain.product.ProductQueryService;
import com.saebom.keebstation.web.dto.api.product.ProductDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductQueryService productQueryService;

    @GetMapping("/{productId}")
    public ProductDetailResponse getProductDetail(@PathVariable Long productId) {
        return productQueryService.getProductDetail(productId);
    }
}