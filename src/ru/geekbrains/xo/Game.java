package ru.geekbrains.xo;

public class Game {
    public static final int SIZE = 3;
    public static final char CHAR_EMPTY = '.';
    public static final char DOT_X = 'X';
    public static final char DOT_0 = '0';
    public static char[][] map;

    public static void main(String[] args) {
        initMap();
        printMap();
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
}
