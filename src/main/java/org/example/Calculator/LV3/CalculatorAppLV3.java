package org.example.Calculator.LV3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CalculatorAppLV3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);


        String input;
        input = "";

        List<Double> resultList = new ArrayList<>();
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();

        calculator.setResult(resultList);

        while (!input.equals("exit")) {
            System.out.println("========계산기========\n");
            System.out.print("양의 정수를 하나 입력하시오 : ");
            double positiveInt1, positiveInt2;

            while(true) {
                try {
                    positiveInt1 = sc.nextDouble();
                    break;
                }
                catch (InputMismatchException e){
                    System.out.print("잘못된 입력입니다. 다시 입력하시오 : ");
                    sc.nextLine();
                }
            }

            System.out.print("양의 정수를 하나 더 입력하시오 : ");
            while(true) {
                try {
                    positiveInt2 = sc.nextDouble();
                    break;
                }
                catch (InputMismatchException e){
                    System.out.print("잘못된 입력입니다. 다시 입력하시오 : ");
                    sc.nextLine();
                }
            }

            System.out.print("사칙연산 기호를 입력하시오(+,-,*,/) : ");

            String operation = sc.next();

            double result = calculator.calculate(operation, positiveInt1, positiveInt2);
            calculator.saveResult(result);

            System.out.printf("계산 결과는 : %.1f %s %.1f = %.1f 입니다.\n\n", positiveInt1, operation, positiveInt2, result);
            System.out.println("그만하려면 exit을 입력하세요\n계속하려면 exit 이외 어떤 값도 상관 없음.\n");
            input = sc1.nextLine();

        }
        System.out.println("계산기 종료!\n");

        System.out.println("계산 결과 값 조회\n");
        List<Double> resultList1 = calculator.getResultList();

        int count = 1;

        for (Double r : resultList1){
            System.out.println(count+"번째 " + r);
            count ++;
        }

        System.out.println("\n계산 결과 하나 삭제 할까요?\n");
        String yesOrNo = sc.next();

        if (yesOrNo.equals("yes")){
            if (!resultList.isEmpty()) {
                calculator.deleteResult();

                System.out.println("\n삭제 후 결과\n");
                if (resultList.isEmpty()){
                    System.out.println("저장된 값 없음.");
                }

                int count2 = 1;

                for (Double r : resultList1){
                    System.out.println(count2+"번째 " + r);
                    count2 ++;
                }
            }
            else {
                System.out.println("결과 값이 존재하지 않습니다!");
            }

        }
        else {
            System.out.println("삭제를 하지 않고 계산기를 종료합니다.");
        }


        System.out.println("\n값을 입력하시면 입력한 값보다 큰 저장된 값을 보여드립니다!!!\n\n원하는 값을 입력하시오");
        double input2 = sc.nextDouble();

        calculator.searchBiggerValue(input2);


    }
}
