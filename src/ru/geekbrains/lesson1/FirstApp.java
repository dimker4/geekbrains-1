package ru.geekbrains.lesson1;

public class FirstApp {
    // Задание 1
    public static void main(String[] args)
    {
        // Задание 2
        byte varByte = 0;
        short varShort = 0;
        int varInt = 0;
        long varLong = 0;
        float varFloat = 0.0f;
        double varDouble = 0;
        char varChar = 'a';
        boolean varBool = true;

        // Задание 3
        double a = 1, b = 2, c = 3, d = 4;
        System.out.println(calcExpression(a, b, c, d));

        // Задание 4
        int t1 = 10;
        int t2 = 2;
        System.out.println(checkSum(t1, t2));

        // Задание 5
        int s = 0;
        printPositiveOrNegative(s);

        // Задание 6
        int s1 = -10;
        System.out.println(checkNegative(s1));

        // Задание 7
        String name = "Vladimir";
        sayHello(name);

        // Задание 8
        int year = 505;
        checkLeapYear(year);

    }

    public static double calcExpression (double a, double b, double c, double d)
    {
        return a * (b + (c / d));
    }

    public static boolean checkSum (int a, int b)
    {
        return a + b >= 10 && a + b <= 20;
    }

    public static void printPositiveOrNegative (int a)
    {
        if (a >= 0)
        {
            System.out.println("number is positive");
        }
        else
        {
            System.out.println("number is negative");
        }
    }

    public static boolean checkNegative (int a)
    {
        return a < 0;
    }

    public static void sayHello (String name)
    {
        System.out.println("Привет, " + name + "!");
    }

    public static void checkLeapYear (int year)
    {
        boolean result = false;
        if (year % 400 == 0) result = true;
        else if (year % 4 == 0)
        {
            if (year % 100 == 0) result = false;
            else result = true;
        }

        if (result) System.out.println(year + " is leap year");
        else System.out.println(year + " is not leap year");

    }
}
