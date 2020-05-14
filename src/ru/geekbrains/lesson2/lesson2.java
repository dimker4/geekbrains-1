package ru.geekbrains.lesson2;

public class lesson2 {

    public static void main(String[] args)
    {
        int[] array = {0, 1, 2, 3, 4, 5, -1, 10, -3}; 

        // Задание 5
        System.out.println("min: " + getMinFromArray(array));
        System.out.println("max: " + getMaxFromArray(array));

        //Задание 6
        System.out.println(checkSumParts(array));

        // Задание 7
        int[] result;
        int offset = 2; // Сдвиг
        result = transformArray(array, offset);

        for (int i = 0; i <= array.length-1; i++)
        {
            System.out.print(result[i] + " ");
        }
    }

    // Задание 5
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