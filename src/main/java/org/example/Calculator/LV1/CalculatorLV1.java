package org.example.Calculator.LV1;

import java.util.Scanner;

public class CalculatorLV1 {
    public CalculatorLV1() {
        Scanner sc = new Scanner(System.in);

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
        System.out.println("계산 결과는 : "+result+"입니다.");
    }


}

