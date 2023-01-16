package ru.gb;

/*
Найти сумму элементов главной диагонали в двумерном массиве.
Найти сумму элементов побочной диагонали в двумерном массиве.
*/

public class SumDiagonal {
    public static void main(String[] args) {

        int[][] regularMatrix = {{1, 2, 3, 4, 5},
                                 {2, 4, 3, 5, 6},
                                 {6, 7, 3, 2, 6},
                                 {1, 7, 6, 2, 9},
                                 {1, 5, 2, 7, 8}};

        System.out.println(findMainDiagonalSum(regularMatrix)); // 1 + 4 + 3 + 2 + 8 = 18
        System.out.println(findSubDiagonalSum(regularMatrix)); // 5 + 5 + 3 + 7 + 1 = 21

    }

    // Линейная сложность - O(n)
    public static int findMainDiagonalSum(int[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix.length != matrix[i].length) {
                throw new IllegalArgumentException("Матрица не является квадратной!");
            }
            sum += matrix[i][i];
        }

        return sum;
    }

    // Линейная сложность - O(n)
    public static int findSubDiagonalSum(int[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix.length != matrix[i].length) {
                throw new IllegalArgumentException("Матрица не является квадратной!");
            }
            sum += matrix[i][matrix.length - 1 - i];
        }

        return sum;
    }
}
