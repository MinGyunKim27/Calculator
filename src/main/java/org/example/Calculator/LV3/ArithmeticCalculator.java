package org.example.Calculator.LV3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ArithmeticCalculator<T extends Number> {

    public enum Operator {
        ADD("+"),
        SUB("-"),
        MUL("*"),
        DIV("/");

        private final String symbol;

        Operator(String symbol) {
            this.symbol = symbol;
        }

        public static Operator fromSymbol(String symbol) {
            for (Operator op : values()) {
                if (op.symbol.equals(symbol)) {
                    return op;
                }
            }
            return null;
        }
    }


    private double result;
    private T num1;
    private T num2;

    private List<Double> resultList = new ArrayList<>();

    private double add() {
        return num1.doubleValue() + num2.doubleValue();
    }

    private double subtract() {
        return num1.doubleValue() - num2.doubleValue();
    }

    private double multiply() {
        return num1.doubleValue() * num2.doubleValue();
    }

    private double divide() {
        return num1.doubleValue() / num2.doubleValue();
    }

    public double calculate(String operator, T num1, T num2) {
        this.num1 = num1;
        this.num2 = num2;
        Operator enumOperator = Operator.fromSymbol(operator);

        switch (enumOperator) {
            case ADD:
                result = this.add(); break;
            case SUB:
                result = this.subtract(); break;
            case MUL:
                result = this.multiply(); break;
            case DIV:
                if (num2.doubleValue() != 0.0) {
                    result = this.divide();
                } else {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                }
                break;
            default:
                System.out.println("지원하지 않는 연산자입니다.");
        }

        return result;
    }

    public void setResult(List<Double> resultList) {
        this.resultList = resultList;
    }

    public void saveResult(Double result) {
        resultList.add(result);
    }

    public List<Double> getResultList() {
        return resultList;
    }

    public void deleteResult() {
        if (!resultList.isEmpty()) {
            resultList.remove(0);
        }
    }

    public void searchBiggerValue(double num){
        System.out.print("입력한 값보다 큰 값들은 : ");
        int count = 1;
        for (double a : this.resultList.stream().filter(a -> a > num).toList()){
            if (count != 1){
                System.out.print(", "+a);
            }
            else {
                System.out.print(a);
            }
            count ++;
        }
        System.out.println("입니다");


    }
}
