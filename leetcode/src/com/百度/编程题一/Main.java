package com.百度.编程题一;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arry = new int[n];
        for (int i = 0; i < n; i++) {
            arry[i] = sc.nextInt();
        }
        System.out.println(maxNum(arry));
    }

    public static String maxNum(int[] arry) {
        int n5 = 0, n0 = 0;
        for (int i = 0; i < arry.length; i++) {
            if (arry[i] == 5) {
                n5++;
            } else {
                n0++;
            }
        }
        if (n5 % 9 == 0) {
        } else {
            while (n5 % 9 != 0) {
                n5--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n5; i++) {
            sb.append(5);
        }
        for (int i = 0; i < n0; i++) {
            sb.append(0);
        }
        if (n5 < 9) {
            return "-1";
        }
        return sb.toString();
    }
}
