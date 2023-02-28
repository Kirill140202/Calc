package com.packages.Калькулятор.Calc;

public class Calculator {


     static int calculate(int number1, int number2, String operation) {
        int result = 0;
        try {
            switch (operation) {
                case "+" -> result = number1 + number2;
                case "-" -> result = number1 - number2;
                case "*" -> result = number1 * number2;
                case "/" -> result = number1 / number2;
                default -> throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println("\"" + operation + "\" Неверный знак операции");

        }
        return result;
    }

}