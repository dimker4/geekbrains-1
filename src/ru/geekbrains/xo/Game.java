package ru.geekbrains.xo;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static final int SIZE = 3;
    public static final char CHAR_EMPTY = '.';
    public static final char DOT_X = 'X';
    public static final char DOT_0 = '0';
    public static final int DOTS_TO_WIN = 3;
    public static char[][] map;

    public static void main(String[] args) {
        initMap();
        printMap();

        do {
            doHumanTurn();
            printMap();
            if (victoryCondition(DOT_X)) {
                System.out.println("Победили " + DOT_X);
                break;
            }
            if (isFullMap()) {
                System.out.println("Ничья! ");
                break;
            }

            doAiTurn();
            printMap();
            if (victoryCondition(DOT_0)) {
                System.out.println("Победили " + DOT_0);
                break;
            }

            if (isFullMap()) {
                System.out.println("Ничья! ");
                break;
            }
        } while (true);

    }

    public static void initMap() {
        map = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i ++) {
            for (int j = 0; j < SIZE; j ++) {
                map[i][j] = CHAR_EMPTY;
            }
        }
    }

    public static void printMap() {

        for (int i = 0; i <= SIZE; i ++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < SIZE; i ++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j ++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isValidCell (int y, int x) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE)
        {
            return false;
        }
        if (map[y][x] == CHAR_EMPTY)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void doHumanTurn () {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int y = 0;

        System.out.println("Человек ходит: ");
        System.out.println("Введи координаты в формате через пробел: Y X ");

        do {
            y = sc.nextInt() - 1;
            x = sc.nextInt() - 1;
        } while (!isValidCell(y, x));

        map[y][x] = DOT_X;
    }

    public static void doAiTurn () {
        int x = 0;
        int y = 0;
        int[] arrayCoordinate = new int[2];

        do {
            arrayCoordinate = getCoordinateForTurnAi();
            y = arrayCoordinate[0];
            x = arrayCoordinate[1];

        } while (!isValidCell(y, x));

        System.out.println("Комьютер сходил " + (y + 1) + " " + (x + 1));

        map[y][x] = DOT_0;
    }

    public static boolean victoryCondition (char symbol) {
        /* Буду собирать количество указанных симоволов для каждой ситуации (главная, побочная диагонали, строки, столбцы)
         * в одномерный массив, в конце метода буду проверять есть ли в какой-нибудь ячейки колчество символов, необходимое для победы
         */
        int[] arrayWin = new int[SIZE * 2 + 2];
        int cnt = 0;
        for (int i = 0; i < SIZE; i ++) { // Считаем главную диагональ
            if (map[i][i] == symbol) {
                arrayWin[cnt] ++;
            }
        }
        cnt++;

        for (int i = 0; i < SIZE; i ++) {
            for (int j = 0; j < SIZE; j ++) { // Считаем побочную диагональ
                if (i + j == SIZE-1 && map[i][j] == symbol) {
                    arrayWin[cnt] ++;
                }
            }
        }

        cnt++;

        for (int i = 0; i < SIZE; i ++) { // Считаем строки
            for (int j = 0; j < SIZE; j ++) {
                if (map[i][j] == symbol) {
                    arrayWin[cnt] ++;
                }
            }
            cnt++;
        }

        for (int i = 0; i < SIZE; i ++) { // Считаем столбцы
            for (int j = 0; j < SIZE; j ++) {
                if (map[j][i] == symbol) {
                    arrayWin[cnt] ++;
                }
            }
            cnt++;
        }

        for (int i = 0; i < arrayWin.length; i ++) {
            if (arrayWin[i] == DOTS_TO_WIN) {
                return true;
            }
        }
        return false;
    }

    public static int[] getCoordinateForTurnAi () {
        int[] arrayBlock = new int[SIZE * 2 + 2];
        int cnt = 0;
        int[] result = new int[2];
        Random random = new Random();

        for (int i = 0; i < SIZE; i ++) { // Считаем главную диагональ
            if (map[i][i] == DOT_X) {
                arrayBlock[cnt] ++;
            }
        }

        if (arrayBlock[cnt] == DOTS_TO_WIN - 1) { // Если не хвататет 1 до выигрыша, то занимаем её
            for (int i = 0; i < SIZE; i ++) { // Считаем главную диагональ
                if (map[i][i] == CHAR_EMPTY) {
                    result[0] = i;
                    result[1] = i;
                    return result;
                }
            }
        }

        cnt++;

        for (int i = 0; i < SIZE; i ++) {
            for (int j = 0; j < SIZE; j ++) { // Считаем побочную диагональ
                if (i + j == SIZE-1 && map[i][j] == DOT_X) {
                    arrayBlock[cnt] ++;
                }
            }
        }

        if (arrayBlock[cnt] == DOTS_TO_WIN - 1) { // Если не хвататет 1 до выигрыша, то занимаем её
            for (int i = 0; i < SIZE; i ++) { // Считаем побочную диагональ
                for (int j = 0; j < SIZE; j ++) {
                    if (i + j == SIZE-1 && map[i][j] == CHAR_EMPTY) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
        }

        cnt++;

        for (int i = 0; i < SIZE; i ++) { // Считаем строки
            for (int j = 0; j < SIZE; j ++) {
                if (map[i][j] == DOT_X) {
                    arrayBlock[cnt] ++;
                }
            }
            if (arrayBlock[cnt] == DOTS_TO_WIN - 1) { // Когда нашли строку в которой не хватает 1 элемента
                for (int k = 0; k < SIZE; k ++) { // Начинаем перебирать, что бы найти пустую клетку
                    if (map[i][k] == CHAR_EMPTY) {
                        result[0] = i;
                        result[1] = k;
                        return result;
                    }
                }
            }
            cnt++;
        }

        for (int i = 0; i < SIZE; i ++) { // Считаем столбцы
            for (int j = 0; j < SIZE; j ++) {
                if (map[j][i] == DOT_X) {
                    arrayBlock[cnt] ++;
                }
            }

            if (arrayBlock[cnt] == DOTS_TO_WIN - 1) { // Когда нашли столбец в которой не хватает 1 элемента
                for (int k = 0; k < SIZE; k ++) { // Начинаем перебирать, что бы найти пустую клетку
                    if (map[k][i] == CHAR_EMPTY) {
                        result[0] = k;
                        result[1] = i;
                        return result;
                    }
                }
            }
            cnt++;
        }

        result[0] = random.nextInt(SIZE);
        result[1] = random.nextInt(SIZE);

        return result;
    }

    public static boolean isFullMap() {
        int cnt = 0;
        for (int i = 0 ; i < SIZE; i ++) {
            for (int j = 0; j < SIZE; j ++) {
                if (map[i][j] == CHAR_EMPTY) {
                    cnt++;
                }
            }
        }

        if (cnt == 0) return true;

        return false;
    }
}
