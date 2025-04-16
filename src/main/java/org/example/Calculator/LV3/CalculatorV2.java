package org.example.Calculator.LV3;

import java.util.ArrayList;

public class CalculatorV2 {
    private double result;

    private ArrayList<String> resultList = new ArrayList<String>();
    public CalculatorV2(){
    }

    private double add(int num1,int num2){
        return num1 + num2;
    }

    private double subtract(int num1, int num2){
        return num1 - num2;
    }

    private double multiply(int num1, int num2){
        return num1 * num2;
    }

    private double divide(int num1, int num2){
        return (double) num1 / (double) num2;
    }

    public double calculate(String operator, int num1, int num2){
        switch (operator) {
            case "+": result = this.add(num1,num2); break;
            case "-": result = this.subtract(num1,num2); break;
            case "*": result = this.multiply(num1,num2); break;
            case "/": if (num2 != 0) {
                result = this.divide(num1,num2);
            }
            else {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            }
                break;
        }

        return result;
    }


    public void setResult(ArrayList<String> resultList) {
        this.resultList = resultList;
    }

    public void saveResult(String result){
        resultList.add(result);
    }

    public ArrayList<String> getResultList() {
        return resultList;
    }

    public void deleteResult(){
        resultList.remove(0);
    }
}
