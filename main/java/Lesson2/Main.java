package Lesson2;

import java.util.Arrays;

/**
 *Java. Level 2. Lesson 2.
 *@author Ivan Dudorov
 *
 * Задание:
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
при подаче массива другого размера необходимо бросить исключение MyArraySizeException.

2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или
текст вместо числа), должно быть брошено исключение MyArrayDataException, с детализацией в какой
именно ячейке лежат неверные данные.

3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException
и MyArrayDataException, и вывести результат расчета.
 **/

public class Main {
    public static void main(String[] args) {
        String[][] normalArrayToSum = {
                {"1",   "2",    "3",    "4"},
                {"5",   "6",    "7",    "8"},
                {"9",   "10",   "11",   "12"},
                {"13",  "14",   "15",   "16"}
        };
        String[][] wrongRowArrayToSum = {
                {"1",   "2",    "3",    "4"},
                {"5",   "6",    "7",    "8"},
                {"9",   "10",   "11",   "12"}
        };
        String[][] wrongDataArrayToSum = {
                {"1",   "2",    "3",    "4"},
                {"5",   "A",    "7",    "8"},
                {"9",   "10",   "11",   "12"},
                {"13",  "14",   "15",   "16"}
        };

        System.out.println("\nМассив 1: " + Arrays.deepToString(normalArrayToSum));
        try {
            System.out.println("Нормальный массив 4х4. Сумма элементов: " + sumArray(normalArrayToSum));
        }catch (MyArraySizeException e){
            System.out.println("Внимание! Неправильный размер массива!");
        }catch (MyArrayDataException e) {
            System.out.println("Внимание! В ячейке массива [" + (e.column + 1) + "][" + (e.row + 1) +
                    "] содержатся не целые числа!");
        }

        System.out.println("\nМассив 2: " + Arrays.deepToString(wrongRowArrayToSum));
        try {
            System.out.println("Неправильный массив 4х3. Сумма элементов: " + sumArray(wrongRowArrayToSum));
        }catch (MyArraySizeException e){
            System.out.println("Внимание! Неправильный размер массива!");
        }catch (MyArrayDataException e) {
            System.out.println("Внимание! В ячейке массива [" + (e.column + 1) + "][" + (e.row + 1) +
                    "] содержатся не целые числа!");
        }

        System.out.println("\nМассив 3: " + Arrays.deepToString(wrongDataArrayToSum));
        try {
            System.out.println("Неправильный массив 4х4 с ошибкой данных. Сумма элементов: " + sumArray(wrongDataArrayToSum));
        }catch (MyArraySizeException e){
            System.out.println("Внимание! Неправильный размер массива!");
        }catch (MyArrayDataException e) {
            System.out.println("Внимание! В ячейке массива [" + (e.column + 1) + "][" + (e.row + 1) +
                    "] содержатся не целые числа!");
        }
    }

    public static int sumArray(String[][] arrToSum){
        int sum = 0;

        //Проверяем, что в массиве 4 строки
        if(arrToSum.length < 4) throw new MyArraySizeException();

        //Проверяем, что в массиве в каждой строке по 4 элемента
        for (int i = 0; i < arrToSum.length; i++) {
            if(arrToSum[i].length < 4) throw new MyArraySizeException();
        }

        //Суммирование данных массива
        for (int i = 0; i < arrToSum.length; i++) {
            for (int j = 0; j < arrToSum[i].length; j++) {
                try {
                    sum += Integer.parseInt(arrToSum[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}
