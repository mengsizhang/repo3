package com.nowcoder.网易.小易的升级之路;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int sum = sc.nextInt();
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i]=sc.nextInt();
                if (num[i] > sum) {
                    sum += yshu_Max(num[i], sum);
                } else {
                    sum += num[i];
                }
            }
            System.out.println(sum);
        }
    }

    public static int yshu_Max(int m, int n) {
        int temp = 1, yshu = 1;
        if (n < m) {
            temp = n;
            n = m;
            m = temp;
        }
        while (m != 0) {
            temp = n % m;
            n = m;
            m = temp;
        }
        yshu = n;
        return yshu;
    }
}
