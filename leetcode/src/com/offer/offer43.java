package com.offer;

/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：5
 */
public class offer43 {
    public int countDigitOne(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            while (i > 0) {
                if (i % 10 == 1) {
                    count++;
                }
                i = i / 10;
            }
        }
        return count;
    }
}
