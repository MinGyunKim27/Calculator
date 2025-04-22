package org.example.Calculator.LV2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CalculatorAppLV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);


        String input;
        input = "";

        List<String> resultList = new ArrayList<>();
        Calculator calc = new Calculator();
        
        calc.setResult(resultList);

        while (!input.equals("exit")) {
            System.out.println("========계산기========\n");
            System.out.print("양의 정수를 하나 입력하시오 : ");
            int positiveInt1, positiveInt2;

            while(true) {
                try {
                    positiveInt1 = sc.nextInt();
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
                    positiveInt2 = sc.nextInt();
                    break;
                }
                catch (InputMismatchException e){
                    System.out.print("잘못된 입력입니다. 다시 입력하시오 : ");
                }
            }

            System.out.print("사칙연산 기호를 입력하시오(+,-,*,/) : ");
            String operation = sc.next();

            double result = 0.0;
            try {
                result = calc.calculate(operation, positiveInt1, positiveInt2);
            }
            catch (ArithmeticException e){
                System.out.println(e.getMessage()+"\n다시 입력하세요!!\n");
                continue;
            }
            String record = String.format("계산 결과는 : %d %s %d = %.1f 입니다.", positiveInt1, operation, positiveInt2, result);
            calc.saveResult(record);

            System.out.printf("\n계산 결과는 : %d %s %d = %.1f 입니다.\n\n", positiveInt1, operation, positiveInt2, result);
            System.out.println("그만하려면 exit을 입력하세요\n계속하려면 exit 이외 아무 값이나 입력하시오.\n");
            input = sc1.nextLine();

        }
        System.out.println("\n계산기 종료!\n");

        System.out.println("계산 결과 값 조회\n");
        List<String> resultList1 = calc.getResultList();

        int count = 1;

        for (String r : resultList1){
            System.out.println(count+"번째 " + r);
            count ++;
        }

        System.out.println("\n계산 결과 하나 삭제 할까요?\n");
        String yesOrNo = sc.next();

        if (yesOrNo.equals("yes")){
            if (!resultList.isEmpty()) {
                calc.deleteResult();

                System.out.println("\n삭제 후 결과\n");
                if (resultList.isEmpty()){
                    System.out.println("저장된 값 없음.");
                }

                int count2 = 1;

                for (String r : resultList1){
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





    }
}
