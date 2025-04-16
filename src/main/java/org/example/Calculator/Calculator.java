package org.example.Calculator;

import org.example.Calculator.LV1.CalculatorLV1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        input = "";
        do {
            new CalculatorLV1();
            System.out.println("그만하려면 exit을 입력하세요\n계속하려면 exit 이외 어떤 값도 상관 없음.");
            input = sc.nextLine();
        }
        while (!input.equals("exit"));

    }
}
