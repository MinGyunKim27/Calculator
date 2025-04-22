package org.example.Calculator.LV3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// 연산자 유효성 검사 클래스
class OperatorValidator {

    // 유효한 연산자가 들어올 때까지 반복 입력 받기
    public String getValidOperator(String operator) {
        while (true) {
            if (isValid(operator)) {
                return operator;
            } else {
                System.out.println("잘못된 연산자입니다. 다시 입력해주세요. (예: +, -, *, /)");
            }
        }
    }

    // 내부 유효성 검사
    private boolean isValid(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }
}

class InputHandler {

    private final Scanner scanner = new Scanner(System.in);

    // 모든 실수(double) 입력 받기 (음수/0 포함 허용)
    public double getDouble(String operator) {
        double input;
        while (true) {
            System.out.print(operator);
            try {
                input = scanner.nextDouble();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                scanner.nextLine(); // 입력 버퍼 정리
            }
        }
    }

    public String getString(String message) {
        System.out.print(message);
        return scanner.next();
    }

    public String getFullLine(String message) {
        System.out.print(message);
        return new Scanner(System.in).nextLine();
    }
}


public class CalculatorAppLV3 {
    public static void main(String[] args) {
        InputHandler input = new InputHandler();
        OperatorValidator opValidator = new OperatorValidator();

        List<Double> resultList = new ArrayList<>();
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();
        calculator.setResult(resultList);

        String userInput = "";

        while (!userInput.equals("exit")) {
            System.out.println("======== 계산기 ========\n");

            double num1 = input.getDouble("첫 번째 숫자를 입력하시오: ");
            double num2 = input.getDouble("두 번째 숫자를 입력하시오: ");

            String operatorInput = input.getString("사칙연산 기호를 입력하시오(+,-,*,/) : ");
            String validatedOperator = opValidator.getValidOperator(operatorInput);

            double result = 0.0;
            try {
                result = calculator.calculate(validatedOperator, num1, num2);
            }
            catch (ArithmeticException e){
                System.out.println(e.getMessage()+"\n다시 입력하세요!!\n");
                continue;
            }
            calculator.saveResult(result);

            System.out.printf("계산 결과는: %.1f %s %.1f = %.1f 입니다.\n\n", num1, validatedOperator, num2, result);

            userInput = input.getFullLine("계속하려면 아무 키나 입력, 종료하려면 'exit'을 입력하세요: ");
        }

        System.out.println("\n계산기 종료!\n");

        // 결과 조회
        System.out.println("계산 결과 값 조회\n");
        List<Double> resultList1 = calculator.getResultList();
        int count = 1;
        for (Double r : resultList1) {
            System.out.println(count + "번째 " + r);
            count++;
        }

        // 결과 삭제 여부
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

        // 큰 값 검색
        double searchTarget = input.getDouble("\n입력한 값보다 큰 저장 결과를 조회합니다.\n값을 입력하세요: ");
        calculator.searchBiggerValue(searchTarget);
    }
}
