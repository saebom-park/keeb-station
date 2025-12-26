# Architecture Decisions Log

## 목적
keeb-station 프로젝트에서 내려진 중요한 설계/기술 결정을 기록한다.

---

## 2025-12-26
### 금액 컬럼 BIGINT 사용
- 결정: 모든 금액 관련 컬럼을 BIGINT로 통일
- 이유:
  - 금액 정확성
  - 확장성
  - 실무 기준 부합

---

## 2025-12-26
### ProductOption을 실제 판매 단위로 채택
- 결정: 장바구니/주문은 ProductOption 기준
- 이유:
  - 옵션별 재고 관리
  - 주문 이력 정확성