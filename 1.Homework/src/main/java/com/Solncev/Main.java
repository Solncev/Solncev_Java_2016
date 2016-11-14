package com.Solncev;

import javafx.scene.control.SplitPane;

import java.util.Scanner;

/**
 * Created by Марат on 14.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        Answer answer = new Answer();
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(answer.getAnswer(a, b));
    }
}
