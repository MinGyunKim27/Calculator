package org.example.Calculator.LV1;

import java.util.Scanner;

public class CalculatorAppLV1 {
    public static void main(String[] args) {
        // 사용자 입력을 받기 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);   // 숫자 입력용
        Scanner sc1 = new Scanner(System.in);  // 문자열 입력용 (exit 여부)

        String input;
        input = "";

        // 사용자로부터 "exit"이 입력되기 전까지 계속 반복
        while (!input.equals("exit")) {
            System.out.println("========계산기========");

            // 첫 번째 양의 정수 입력
            System.out.println("양의 정수를 하나 입력하시오");
            int positiveInt1 = sc.nextInt();

            // 두 번째 양의 정수 입력
            System.out.println("양의 정수를 하나 더 입력하시오");
            int positiveInt2 = sc.nextInt();

            // 사칙연산 기호 입력
            System.out.println("사칙연산 기호를 입력하시오(+,-,*,/)");
            String operation = sc.next();

            double result = 0; // 결과 값을 저장할 변수

            // 입력된 연산 기호에 따라 계산 수행
            switch (operation) {
                case "+":
                    result = positiveInt1 + positiveInt2;
                    break;
                case "-":
                    result = positiveInt1 - positiveInt2;
                    break;
                case "*":
                    result = positiveInt1 * positiveInt2;
                    break;
                case "/":
                    // 나눗셈은 0으로 나누는 경우 예외 처리
                    if (positiveInt2 != 0) {
                        result = (double) positiveInt1 / (double) positiveInt2;
                    } else {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    }
                    break;
            }

            // 계산 결과 출력
            System.out.printf("계산 결과는 : %d %s %d = %.1f 입니다.\n\n", positiveInt1, operation, positiveInt2, result);

            // 반복 여부 결정
            System.out.println("그만하려면 exit을 입력하세요\n계속하려면 exit 이외 어떤 값도 상관 없음.\n");
            input = sc1.nextLine(); // 사용자 입력 받기
        }

        // 반복 종료 후 메시지 출력
        System.out.println("계산기 종료!");
    }
}
