package ru.gb;

/*
4. Реализовать сдвиг элементов в массиве на n влево или вправо.
*/

import java.util.Arrays;

public class ElementShift {
    public static void main(String[] args) {

        int[] arrayNumber1 = {1, 2, 3, 4, 5};
        shift(arrayNumber1, 2);
        System.out.println(Arrays.toString(arrayNumber1));

        int[] arrayNumber2 = {1, 2, 3, 4, 5};
        shift(arrayNumber2, -32);
        System.out.println(Arrays.toString(arrayNumber2));

    }

    // Хотелось реализовать линейную сложность алгоритма... вроде бы получилось.
    // Про System.arraycopy я знаю... этот статический метод значительно бы упростил мой код
    // Но я хотел справиться без него.
    public static void shift(int[] array, int shiftCount) {
        int checkedShiftCount;
        int absoluteShiftCount;

        if (shiftCount < 0) {
            absoluteShiftCount = Math.abs(shiftCount);
        } else {
            absoluteShiftCount = shiftCount;
        }

        if (absoluteShiftCount == array.length ||
                    absoluteShiftCount % array.length == 0) {
            throw new IllegalArgumentException("Длина сдвига бессмысленна!");
        }
        if (absoluteShiftCount > array.length) {
            checkedShiftCount = absoluteShiftCount % array.length;
        } else {
            checkedShiftCount = absoluteShiftCount;
        }

        if (shiftCount > 0) {
            shiftPositive(array, checkedShiftCount);
        } else {
            shiftNegative(array, checkedShiftCount);
        }
    }

    public static void shiftPositive(int[] arrayForShift, int shiftCount) {
        int shiftIndex = arrayForShift.length - shiftCount;
        int[] subArray = new int[shiftCount];

        for (int i = shiftIndex, j = 0; i < arrayForShift.length; i++, j++) {
            subArray[j] = arrayForShift[i];
        }
        for (int i = 0, j = shiftIndex - 1; i < shiftIndex; i++, j--) {
            arrayForShift[arrayForShift.length - 1 - i] = arrayForShift[j];
        }
        for (int i = 0; i < subArray.length; i++) {
            arrayForShift[i] = subArray[i];
        }
    }

    public static void shiftNegative(int[] arrayForShift, int shiftCount) {
        int shiftIndex = arrayForShift.length - shiftCount;
        int[] subArray = new int[shiftCount];

        for (int i = 0; i < subArray.length; i++) {
            subArray[i] = arrayForShift[i];
        }
        for (int i = 0, j = shiftCount; j < arrayForShift.length; i++, j++) {
            arrayForShift[i] = arrayForShift[j];
        }
        for (int i = shiftIndex, j = 0; i < arrayForShift.length; i++, j++) {
            arrayForShift[i] = subArray[j];
        }
    }
}
