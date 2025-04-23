package org.example.Calculator.LV3;

import java.util.ArrayList;
import java.util.List;

// 사용자 입력 처리 클래스


// 계산기 실행 메인 클래스
public class CalculatorAppLV3 {
    public static void main(String[] args) {
        InputHandler input = new InputHandler();
        OperatorValidator opValidator = new OperatorValidator();

        List<Double> resultList = new ArrayList<>();
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();
        calculator.setResult(resultList);

        String userInput = "";

        // 메인 루프: 사용자에게 계속 계산할 것인지 묻기
        while (!userInput.equals("exit")) {
            System.out.println("======== 계산기 ========\n");

            // 숫자 2개 입력
            double num1 = input.getDouble("첫 번째 숫자를 입력하시오: ");
            double num2 = input.getDouble("두 번째 숫자를 입력하시오: ");

            // 연산자 입력 및 유효성 검사
            String operatorInput = input.getString("사칙연산 기호를 입력하시오(+,-,*,/) : ");
            String validatedOperator = opValidator.getValidOperator(operatorInput);

            double result = 0.0;

            // 계산 및 예외 처리
            try {
                result = calculator.calculate(validatedOperator, num1, num2);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage() + "\n다시 입력하세요!!\n");
                continue;
            }

            // 결과 저장 및 출력
            calculator.saveResult(result);
            System.out.printf("계산 결과는: %.1f %s %.1f = %.1f 입니다.\n\n", num1, validatedOperator, num2, result);

            // 계속할지 여부 확인
            userInput = input.getFullLine("계속하려면 아무 키나 입력, 종료하려면 'exit'을 입력하세요: ");
        }

        System.out.println("\n계산기 종료!\n");

        // 저장된 결과 전체 출력
        System.out.println("계산 결과 값 조회\n");
        List<Double> resultList1 = calculator.getResultList();
        int count = 1;
        for (Double r : resultList1) {
            System.out.println(count + "번째 " + r);
            count++;
        }

        // 결과 삭제 여부 확인 및 처리
        String deleteChoice = input.getString("\n계산 결과 하나 삭제할까요? (yes/no): ");
        if (deleteChoice.equalsIgnoreCase("yes")) {
            if (!resultList.isEmpty()) {
                calculator.deleteResult();
                System.out.println("\n삭제 후 결과\n");
                if (resultList.isEmpty()) {
                    System.out.println("저장된 값 없음.");
                } else {
                    int count2 = 1;
                    for (Double r : resultList1) {
                        System.out.println(count2 + "번째 " + r);
                        count2++;
                    }
                }
            } else {
                System.out.println("결과 값이 존재하지 않습니다!");
            }
        } else {
            System.out.println("삭제하지 않고 계산기를 종료합니다.");
        }

        // 특정 값보다 큰 결과 값 검색
        double searchTarget = input.getDouble("\n입력한 값보다 큰 저장 결과를 조회합니다.\n값을 입력하세요: ");
        calculator.searchBiggerValue(searchTarget);
    }
}
