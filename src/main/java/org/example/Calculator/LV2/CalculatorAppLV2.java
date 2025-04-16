package org.example.Calculator.LV2;

import java.util.Scanner;

public class CalculatorAppLV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);


        String input;
        input = "";
        while (!input.equals("exit")) {
            System.out.println("========계산기========");
            System.out.println("양의 정수를 하나 입력하시오");
            int positiveInt1 = sc.nextInt();
            System.out.println("양의 정수를 하나 더 입력하시오");
            int positiveInt2 = sc.nextInt();

            System.out.println("사칙연산 기호를 입력하시오(+,-,*,/)");
            String operation = sc.next();

            double result = 0;
            switch (operation) {
                case "+": result = positiveInt1 + positiveInt2; break;
                case "-": result = positiveInt1 - positiveInt2; break;
                case "*": result = positiveInt1 * positiveInt2; break;
                case "/": if (positiveInt2 != 0) {
                    result = (double) positiveInt1 / (double) positiveInt2;
                }
                else {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                }
                    break;
            }
            System.out.printf("계산 결과는 : %d %s %d = %.1f 입니다.\n\n", positiveInt1, operation, positiveInt2, result);
            System.out.println("그만하려면 exit을 입력하세요\n계속하려면 exit 이외 어떤 값도 상관 없음.\n");
            input = sc1.nextLine();

        }
        System.out.println("계산기 종료!");


    }
}
