package ru.itis.kpfu.array;

import java.util.Scanner;

/**
 * Created by Марат on 13.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int result = 0;
        for (int x : a) {
            result ^= x;
        }
        System.out.println(result);

    }
}
