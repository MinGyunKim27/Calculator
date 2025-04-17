# 🧮 계산기 프로젝트!

## 📖 프로젝트 소개

이 프로젝트는 LV1, LV2, LV3으로 나누어진 계산기를 만드는 프로젝트입니다!  
단계별로 자바의 핵심 개념들을 실습하며 점진적으로 객체지향적인 구조로 개선해나갑니다.

---

## 🔢 프로젝트 단계별 설명

- **[LV1]** <img src="https://github.com/user-attachments/assets/87bc3748-60a5-488f-9a4e-c0a33a5b07f2" width="20"/>
  - 클래스 없이 자바의 기본 문법만을 사용하여 구현한 계산기
  - `if-else`, `Scanner`, `while` 등 자바 문법 기초 구성

- **[LV2]** <img src="https://github.com/user-attachments/assets/9b593025-eec6-4cdb-b175-49249076afc5" width="20"/>
  - 객체 지향 개념을 적용하여 클래스 정의 및 연산 수행 메서드 작성
  - 계산 결과를 저장하고 삭제하는 기능 추가

- **[LV3]** <img src="https://github.com/user-attachments/assets/26e4659c-361d-4dbf-ae6b-8607ccfa5124" width="20"/>
  - 자바의 Enum, 제네릭, 람다 & 스트림을 적용한 확장형 계산기
  - 입력/연산자 검증 로직을 별도 클래스로 분리하고, 검색 기능 추가

---

## 🎯 이번 프로젝트의 목표

> **자바 문법 실습과 객체 지향 개념 적용**  
> - 단계적으로 리팩토링하며 자바의 다양한 문법과 설계 원칙을 체득하는 것이 목표입니다.

---

## ✨ 주요 기능

- 기본 사칙연산 (덧셈, 뺄셈, 곱셈, 나눗셈)
- 객체지향 설계 (입력/연산 분리)
- 잘못된 입력(숫자, 연산자)에 대한 예외 처리
- 실수 입력(Double) 지원
- 계산 결과 저장 및 리스트 출력
- 특정 값보다 큰 결과 필터링 출력
- 저장된 결과 중 가장 오래된 값 삭제

---

## 🚀 실행 방법

1. 저장소 클론:
```bash
git clone https://github.com/MinGyunKim27/Calculator.git
```

2. Java 개발 환경에서 원하는 단계의 클래스 실행
   - `LV1`: CalculatorLv1
   - `LV2`: CalculatorLv2
   - `LV3`: CalculatorAppLV3

---

## 📁 디렉터리 구조

```
calculator-project/
├── lv1/
│   └── CalculatorLv1.java
├── lv2/
│   └── CalculatorLv2.java
├── lv3/
│   ├── CalculatorAppLV3.java
│   ├── ArithmeticCalculator.java
│   ├── InputHandler.java
│   └── OperatorValidator.java
└── README.md
```

---

## 📌 요구사항

### [LV1]
- 두 개의 숫자와 연산자(+, -, *, /)를 입력받아 계산
- exit 입력 전까지 반복적으로 실행

### [LV2]
- Calculator 클래스를 만들어 연산 기능 분리
- 계산 결과를 저장하는 리스트 도입
- 저장된 결과 중 가장 오래된 항목 삭제 기능 추가

### [LV3]
- 실수 입력(Double) 지원
- 예외처리 클래스를 분리하여 try-catch 로직 간소화
- 연산자 유효성 검증을 별도 클래스로 분리
- enum 기반 연산 처리로 안전성 확보
- 결과 리스트 조회 + 특정 값보다 큰 결과 필터링 출력

---

## 🛠 사용 기술

- Java 17
- Git & GitHub
- IDE: IntelliJ IDEA
- Java Enum, Generic, Stream API

---

## 💡 배운 점

- ✅ 반복되는 `try-catch`는 클래스로 분리하면 재사용성과 가독성이 향상된다.
- ✅ 사용자 입력 및 검증을 별도 클래스로 분리하면 유지보수가 쉬워진다.
- ✅ 연산자는 `enum`으로 관리하면 타입 안정성과 가독성이 증가한다.
- ✅ `Objects.requireNonNull()`을 활용해 null 방어 처리를 명확하게 할 수 있다.
- ✅ `Generic`을 사용하면 다양한 숫자 타입을 처리하는 유연한 계산기를 만들 수 있다.
- ✅ `stream().filter()`를 사용해 리스트 조건 검색을 간결하게 구현할 수 있다.
- ✅ 콘솔 기반 프로그램에서도 구조화된 객체지향 설계가 충분히 적용 가능함을 느꼈다.
