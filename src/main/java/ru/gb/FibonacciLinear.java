package ru.gb;

/*
Найти n-ое число Фибоначчи за O(n).
*/

public class FibonacciLinear {

    public static void main(String[] args) {

        System.out.println(fibonacci(10));

    }

    // Линейная сложность алгоритма - O(n)
    public static int fibonacci(int position) {
        int firstNumber = 0;
        int secondNumber = 1;
        for (int i = 0; i <= position; i++) {
            firstNumber += secondNumber;
            secondNumber = firstNumber - secondNumber;
        }
        return secondNumber;
    }
}
