package com.packages.Калькулятор.Calc;

import java.util.Scanner;

public class Main {
    static String a, b, operation, resultRoman;
   static String input;


    public static void main(String[] args) {
        calc();
    }

    public static String calc() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение пример: 1 + 2 или VI / II ");
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        int numA, numB, result;


        try {
            input = scanner.nextLine();
            String[] split = input.split(" ");
            a = split[0];
            b = split[2];
            operation = split[1];

            String[] operands = input.split("[+\\-*/]");
            if (operands.length != 2){
                throw new Exception();
            }


            boolean f = false;
            for (int i = 0; i < roman.length; i++) {
                if (roman[i].equals(a) || roman[i].equals(b)) {
                    f = true;
                }
            }
            if (f) {
                numA = romanToNumber(a);
                numB = romanToNumber(b);
                if (numA >= 1 && numA <= 10 && numB >= 1 && numB <= 10) {

                    result = Calculator.calculate(numA, numB, operation);
                    if (result <= 0) {
                        throw new RuntimeException();
                    }

                    resultRoman = IsRoman.convert(result);
                    System.out.println(a + " " + operation + " " + b + " = " + resultRoman);
                } else {
                    System.out.println("используются одновременно разные системы счисления ");
                }
            } else {

                numA = Integer.parseInt(a);
                numB = Integer.parseInt(b);


                if (numA >= 1 & numA <= 10 & numB >= 0 & numB <= 10) {

                    result = Calculator.calculate(numA, numB, operation);
                    System.out.println(numA + " " + operation + " " + numB + " = " + result);
                } else {
                    System.out.println("Выражение не верное \nПожалуйста введите как из примера 1 + 2 или VI / II  ");
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Вы ввели какую-то краказябру : " + "\"" + a + " " + operation + " " + b + "\"\nпожалуйста не делайте так!");
        } catch (ArithmeticException e) {
            System.out.println("На ноль делить нельзя!");
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("строка не является математической операцией");
        } catch (RuntimeException e) {
            System.out.println("в римской системе нет отрицательных чисел");
        } catch (Exception e) {
            System.out.println("3 и более операндов использовать нельзя!");
        }
        return input;

    }

    private static int romanToNumber(String roman) {
       switch (roman){
           case "I" : return 1;
           case "II" : return 2;
           case "III" : return 3;
           case "IV" : return 4;
           case "V" : return 5;
           case "VI" : return 6;
           case "VII" : return 7;
           case "VIII" : return 8;
           case "IX" : return 9;
           case "X" : return 10;
       }

        return 0;
    }
}
