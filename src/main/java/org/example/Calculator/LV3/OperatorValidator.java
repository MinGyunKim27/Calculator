package org.example.Calculator.LV3;

// 연산자 유효성 검사 클래스
class OperatorValidator {

    // 유효한 연산자가 들어올 때까지 반복하여 입력받는 메서드
    public String getValidOperator(String operator) {
        while (true) {
            if (isValid(operator)) {
                return operator;
            } else {
                System.out.println("잘못된 연산자입니다. 다시 입력해주세요. (예: +, -, *, /)");
            }
        }
    }

    // 연산자가 +, -, *, / 중 하나인지 확인
    private boolean isValid(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }
}
