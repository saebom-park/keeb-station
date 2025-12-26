# API Specification (v1)

## 공통 규칙
- Base URL: /api
- Response Wrapper 사용
- 에러는 공통 ErrorResponse 반환

---

## Product API

### GET /api/products
- 설명: 상품 목록 조회

### GET /api/products/{id}
- 설명: 상품 상세 조회

---

## Order API

### POST /api/orders
- 설명: 주문 생성

### POST /api/orders/{orderId}/cancel
- 설명: 주문 취소
