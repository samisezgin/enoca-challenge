package org.example;

public class Main {
    public static void main(String[] args) {
        final int ROW_COUNT = 6;
        for (int i = 0; i < ROW_COUNT; i++) {
            if (i == 0) {
                System.out.print("*");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("**");
            }
            System.out.println();
        }
    }
}