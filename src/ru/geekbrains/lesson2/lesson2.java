package ru.geekbrains.lesson2;

public class lesson2 {

    public static void main(String[] args)
    {
        // Задание 1
        change0to1();

        // Задание 2
        createArrMod3();

        // Задание 3
        crateArrMulitpleBy2();

        // Задание 4
        createMatrixDiagonalBy1();

        int[] array = {0, 1, 2, 3, 4, 5, -1, 10, -3};

        // Задание 5
        System.out.println("min: " + getMinFromArray(array));
        System.out.println("max: " + getMaxFromArray(array));

        //Задание 6
        System.out.println(checkSumParts(array));

        // Задание 7
        int[] result;
        int offset = -2; // Сдвиг
        result = transformArray(array, offset);

        for (int i = 0; i <= array.length-1; i++)
        {
            System.out.print(result[i] + " ");
        }
    }

    // Задание 1
    // 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void change0to1 ()
    {
        int[] arr = {0, 0, 0, 1, 1, 1, 0, 1};
        for (int i = 0; i < arr.length; i ++)
        {
            if (arr[i] == 0) arr[i] = 1;
            else arr[i] = 0;
        }
    }

    // Задание 2
    // 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    public static void createArrMod3 ()
    {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = i * 3;
        }
    }

    // Задание 3
    // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void crateArrMulitpleBy2 ()
    {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i ++)
        {
            if (arr[i] < 6) arr[i] *= 2;
        }
    }

    // Задание 4
    //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void createMatrixDiagonalBy1 ()
    {
        int[][] arr = new int[10][10]; // Создадим матрицу с 0
        int size = arr.length;

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                if (i == j) arr[i][j] = 1; // Главная диагонль
                if (j == size-2 - i + 1) arr[i][j] = 1; // Побочная диагональ
            }
        }


        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                System.out.print(arr[i][j] + " ");
                if (j == size - 1) // Для красивого вывода добавим перенос строки
                    System.out.println();
            }
        }
    }

    // Задание 5
    // 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static int getMinFromArray(int[] array)
    {
        int min = array[0];
        for (int i : array)
        {
            if (i < min ) min = i;
        }
        return min;
    }

    public static int getMaxFromArray(int[] array)
    {
        int max = array[0];
        for (int i : array)
        {
            if (i > max ) max = i;
        }
        return max;
    }

    //Задание 6
    /*6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место,
     *      в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
     *      граница показана символами ||, эти символы в массив не входят.
     */
    public static boolean checkSumParts (int[] array)
    {
        int sumLeft = 0; 
        int sumRight = 0;

        for (int i = 0; i <= array.length; i++)
        {
            sumLeft = 0; // Обнулим вначале цикла
            sumRight = 0;

            for (int j = 0; j < i; j++) // Цикл по левой части
            {
                sumLeft += array[j];
            }

            for (int k = i; k <= array.length - 1; k++) // Цикл по правой части
            {
                sumRight += array[k];
            }
            if (sumLeft == sumRight) return true;
        }
        return false;
    }

    // Задание 7
    /*7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
     *         при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     */
    public static int[] transformArray (int[] array, int offset)
    {
        int tmp = 0;
        int size = array.length;   
        if (offset >= 0)
        {
            for (int i = 1; i <= offset; i ++) // Цикл  размера сдвига
            {
                for (int j = 0; j <= size - 1; j++) // Сдвигаем элементы на 1 вправо
                {
                    // Меняем местами через 3-ю переменную
                    tmp = array[j];
                    array[j] = array[size - 1];
                    array[size - 1] = tmp;
                }
            }
        }
        else
        {
            for (int i = 0; i > offset; i--) // Цикл  размера сдвига
            {
                for (int j = size - 1; j >= 0; j--) // Сдвигаем элементы на 1 влево
                {
                    tmp = array[j];
                    array[j] = array[size - 1];
                    array[size - 1] = tmp;
                }
            }
        }
        return array;
    }
}