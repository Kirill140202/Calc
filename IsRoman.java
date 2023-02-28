package com.packages.Калькулятор.Calc;

public class IsRoman {
    static String isRoman(int n, String one, String five, String ten) {
        switch (n) {
            case 1: return one;
            case 2: return one + one;
            case 3: return one + one + one;
            case 4: return one + five;
            case 5: return five;
            case 6: return five + one;
            case 7: return five + one + one;
            case 8: return five + one + one + one;
            case 9: return one + ten;
        }

        return "";
    }

    static String convert(int number) {

        String romanOnes = isRoman(number % 10, "I", "V", "X");
        number /= 10;
        String romanTens = isRoman(number % 10, "X", "L", "C");
        number /= 10;
        String romanHundreds = isRoman(number % 10, "C", "D", "M");


        String result = romanHundreds + romanTens + romanOnes;
        return result;

    }
}

