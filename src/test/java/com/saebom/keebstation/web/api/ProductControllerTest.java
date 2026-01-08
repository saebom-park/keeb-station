package com.saebom.keebstation.web.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("상품 상세 조회: 옵션과 재고를 포함해서 응답한다")
    void getProductDetail_includesOptionsAndStock() throws Exception {
        // given
        long productId = 1L;

        // when & then
        mockMvc.perform(get("/api/products/{productId}", productId)
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$.productId").value(productId))
                .andExpect(jsonPath("$.categoryId", notNullValue()))
                .andExpect(jsonPath("$.name").isNotEmpty())
                .andExpect(jsonPath("$.description").isNotEmpty())
                .andExpect(jsonPath("$.basePrice").isNumber())
                .andExpect(jsonPath("$.status").isNotEmpty())

                .andExpect(jsonPath("$.options").isArray())
                .andExpect(jsonPath("$.options.length()", greaterThan(0)))

                .andExpect(jsonPath("$.options[0].productOptionId", notNullValue()))
                .andExpect(jsonPath("$.options[0].optionSummary").isNotEmpty())
                .andExpect(jsonPath("$.options[0].extraPrice").isNumber())
                .andExpect(jsonPath("$.options[0].status").isNotEmpty())
                .andExpect(jsonPath("$.options[0].isDefault").isBoolean())

                .andExpect(jsonPath("$.options[0].stock").exists())
                .andExpect(jsonPath("$.options[0].stock.quantity").isNumber());
    }

    @Test
    @DisplayName("상품 상세 조회: 존재하지 않으면 404 NOT_FOUND를 응답한다")
    void getProductDetail_notFound_returns404() throws Exception {
        // given
        long productId = 999_999L;

        // when & then
        mockMvc.perform(get("/api/products/{productId}", productId)
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$.code").value("NOT_FOUND"))
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.path").value("/api/products/" + productId));
    }

    @Test
    @DisplayName("상품 목록 조회: 기본 페이징으로 상품 목록을 반환한다")
    void getProducts_returnsProductList() throws Exception {
        // when & then
        mockMvc.perform(get("/api/products")
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content.length()", greaterThan(0)))

                .andExpect(jsonPath("$.content[0].productId").isNumber())
                .andExpect(jsonPath("$.content[0].categoryId").isNumber())
                .andExpect(jsonPath("$.content[0].name").isNotEmpty())
                .andExpect(jsonPath("$.content[0].basePrice").isNumber())
                .andExpect(jsonPath("$.content[0].status").isNotEmpty())

                .andExpect(jsonPath("$.size").value(20))
                .andExpect(jsonPath("$.number").value(0));
    }

    @Test
    @DisplayName("상품 목록 조회: categoryId 필터로 조회한다")
    void getProducts_byCategory() throws Exception {
        // when & then
        mockMvc.perform(get("/api/products")
                        .param("categoryId", "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray());
    }
}