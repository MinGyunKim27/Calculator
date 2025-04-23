package org.example.Calculator.LV3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// 산술 계산기 클래스 (제네릭 타입 T는 Number를 상속받는 타입만 허용)
public class ArithmeticCalculator<T extends Number> {

    // 연산자 종류 정의 (열거형)
    public enum Operator {
        ADD("+"),
        SUB("-"),
        MUL("*"),
        DIV("/");

        private final String symbol;

        Operator(String symbol) {
            this.symbol = symbol;
        }

        // 문자열 연산자를 enum 타입으로 변환하는 메서드
        public static Operator validateSymbol(String symbol) {
            for (Operator op : values()) {
                if (op.symbol.equals(symbol)) {
                    return op;
                }
            }
            return null;
        }
    }

    // 계산 결과 저장 변수
    private double result;

    // 피연산자 1, 2
    private T num1;
    private T num2;

    // 계산 결과를 저장하는 리스트
    private List<Double> resultList = new ArrayList<>();

    // 덧셈 수행
    private double add() {
        return num1.doubleValue() + num2.doubleValue();
    }

    // 뺄셈 수행
    private double subtract() {
        return num1.doubleValue() - num2.doubleValue();
    }

    // 곱셈 수행
    private double multiply() {
        return num1.doubleValue() * num2.doubleValue();
    }

    // 나눗셈 수행
    private double divide() {
        return num1.doubleValue() / num2.doubleValue();
    }

    // 연산자를 기반으로 계산 수행
    public double calculate(String operator, T num1, T num2) {
        this.num1 = num1;
        this.num2 = num2;
        Operator enumOperator = Operator.validateSymbol(operator);

        switch (Objects.requireNonNull(enumOperator)) {
            case ADD:
                result = this.add(); break;
            case SUB:
                result = this.subtract(); break;
            case MUL:
                result = this.multiply(); break;
            case DIV:
                if (num2.doubleValue() != 0.0) {
                    result = this.divide();
                } else {
                    throw new ArithmeticException("나눗셈에서 0으로 나눌 수 없습니다.");
                }
                break;
            default:
                System.out.println("지원하지 않는 연산자입니다.");
        }

        return result;
    }

    // 외부에서 결과 리스트를 주입받음
    public void setResult(List<Double> resultList) {
        this.resultList = resultList;
    }

    // 계산 결과를 리스트에 저장
    public void saveResult(Double result) {
        resultList.add(result);
    }

    // 저장된 계산 결과 리스트 반환
    public List<Double> getResultList() {
        return resultList;
    }

    // 저장된 계산 결과 중 첫 번째 값을 삭제
    public void deleteResult() {
        if (!resultList.isEmpty()) {
            resultList.remove(0);
        }
    }

    // 입력된 값보다 큰 저장 결과들을 필터링하여 출력
    public void searchBiggerValue(double num) {
        if (resultList.isEmpty()) {
            System.out.println("저장된 결과가 없습니다.");
            return;
        }

        List<Double> filtered = resultList.stream()
                .filter(a -> a > num)
                .toList();

        if (filtered.isEmpty()) {
            System.out.println("입력한 값보다 큰 결과는 없습니다.");
            return;
        }

        System.out.print("입력한 값보다 큰 값들은 : ");
        int count = 1;
        for (double a : filtered) {
            if (count != 1) {
                System.out.print(", " + a);
            } else {
                System.out.print(a);
            }
            count++;
        }
        System.out.println("입니다");
    }
}
