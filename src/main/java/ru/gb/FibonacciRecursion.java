package ru.gb;

/*
Рекурсивно найти n-ое число Фибоначчи. Определить сложность.
*/

public class FibonacciRecursion {

    public static void main(String[] args) {

        System.out.println(fibonacci(10));

    }

    // Экспоненциальная сложность алгоритма - O(2^n)
    public static int fibonacci(int position) {
        if (position == 0) {
            return 0;
        }
        if (position == 1 || position == 2) {
            return 1;
        }
        return fibonacci(position - 1) + fibonacci(position - 2);
    }
}
