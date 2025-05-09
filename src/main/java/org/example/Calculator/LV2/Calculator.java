package org.example.Calculator.LV2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private double result;
    private int num1;
    private int num2;
    private String operator;

    private List<String> resultList;
    public Calculator(){
        this.resultList = new ArrayList<String>();
    }

    private double add(){
        return this.num1 + this.num2;
    }

    private double subtract(){
        return this.num1 - this.num2;
    }

    private double multiply(){
        return this.num1 * this.num2;
    }

    private double divide(){
        return (double) this.num1 / (double) this.num2;
    }

    public double calculate(String operator, int num1, int num2){
        this.operator = operator;
        this.num1 = num1;
        this.num2 = num2;

        switch (operator) {
            case "+": result = this.add(); break;
            case "-": result = this.subtract(); break;
            case "*": result = this.multiply(); break;
            case "/": if (num2 != 0) {
                result = this.divide();
            }
            else {
                throw new ArithmeticException("나눗셈에서 0으로 나눌 수 없습니다.");

            }
                break;
        }

        return result;
    }


    public void setResult(List<String> resultList) {
        this.resultList = resultList;
    }

    public void saveResult(String result){
        resultList.add(result);
    }

    public List<String> getResultList() {
        return resultList;
    }

    public void deleteResult(){
        resultList.remove(0);
    }
}
