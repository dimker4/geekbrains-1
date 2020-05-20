package ru.geekbrains.lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class lesson3 {
    public static void main (String[] args) {
        //guessNumber();

        guessWord();
    }

    public static void guessNumber() {
        final int countAttempts = 3;
        int length = 10; // 9 + 1, так как верхняя граница не включается
        int inputNumber = 0; // Введеное число
        int number = 0; // Загаданное число
        String yesNo = "";
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);

        do { // Цикл с постусловием так как игра должна запуститься хотя бы 1 раз
            number = rnd.nextInt(length);
            System.out.println("Угадай число в диапозоне от 0 до " + (length-1));
            System.out.println("У тебя " + countAttempts + " попытки");
            for (int i = 0; i < countAttempts; i ++) {
                inputNumber = sc.nextInt();

                if (inputNumber > number) {
                    System.out.println("Загаданое число меньше!");
                } else if (inputNumber < number) {
                    System.out.println("Загаданое число больше!");
                } else {
                    System.out.println("Да! Ты угадал!");
                    break; // Если угадал, то выйдем из for
                }
            }
            System.out.println("Сыграем еще? Да / Нет");
            yesNo = sc.next();
        } while (yesNo.toLowerCase().equals("да"));
    }

    public static void guessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random rnd = new Random();
        String word = words[rnd.nextInt(words.length)]; // Так как нумерация массива с 0, то из длины ничего не вычитаем
        String inputWord = ""; // Введеное слово
        String tmp = "###############";
        int currentMinLength = 0;
        char[] result = tmp.toCharArray(); // Массив char для удобства вывода
        Scanner sc = new Scanner(System.in);

        System.out.println("Угадай слово из предложенных");
        System.out.println(Arrays.toString(words));
        System.out.println("Твой вариант: ");

        do {
            inputWord = sc.next();
            currentMinLength = getMin(word.length(), inputWord.length()); // Получим минимальную длину из 2-х слов

            for (int i = 0; i < currentMinLength; i ++) {
                if (word.charAt(i) == inputWord.charAt(i) && result[i] == '#') { // Заменим только закрытые буквы
                    result[i] = word.charAt(i);
                }
            }

            tmp = String.valueOf(result).replaceAll("#", ""); // Получим из массива char строку и уберем все #
            if (word.equals(tmp))  System.out.println(word);
                else System.out.println(result); // Если угадали слово, то выводить с # не надо

        } while  (!word.equals(tmp));

        System.out.println("Да! Ты угадал!");
    }

    public static int getMin(int a, int b) {
        return (a > b) ? b : a;
    }
}
