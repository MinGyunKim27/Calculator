package org.example.Calculator.LV3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner = new Scanner(System.in);

    // 실수(double)를 입력받는 메서드 (입력 오류 처리 포함)
    public double getDouble(String message) {
        double input;
        while (true) {
            System.out.print(message);
            try {
                input = scanner.nextDouble();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                scanner.nextLine(); // 입력 버퍼 정리
            }
        }
    }

    // 단어(String) 입력받기
    public String getString(String message) {
        System.out.print(message);
        return scanner.next();
    }

    // 한 줄 전체 입력받기
    public String getFullLine(String message) {
        System.out.print(message);
        return new Scanner(System.in).nextLine();
    }
}