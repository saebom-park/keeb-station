# Architecture Overview

## 목적
keeb-station 서비스의 전체 구조와 책임 분리를 설명한다.

이 문서는:
- 패키지 구조
- 계층 책임
- 도메인 설계 방향
을 한 눈에 이해하기 위한 문서다.

---

## 전체 구조

keeb-station은 Layered Architecture를 기반으로 구성한다.

- Presentation Layer (web)
- Application Layer (service)
- Domain Layer (entity)
- Infrastructure Layer (repository, external)

---

## 패키지 구조

```
com.saebom.keebstation
 ├─ domain
 │   ├─ category
 │   ├─ product
 │   ├─ option
 │   ├─ stock
 │   ├─ order
 │   └─ member
 ├─ web
 │   ├─ api
 │   └─ admin
 ├─ global
 │   ├─ config
 │   ├─ security
 │   ├─ exception
 │   └─ common
 └─ KeebStationApplication
```

---

## 핵심 설계 포인트

- 실제 판매 단위는 ProductOption
- 재고는 ProductOption : Stock = 1 : 1
- 주문 상세(OrderLine)는 ProductOption을 참조
- Admin 기능은 도메인이 아닌 접근 주체(Role) 기준으로 분리

---

## 비고

- 본 문서는 v1 기준
- 구조 변경 시 decisions.md에 반드시 기록
