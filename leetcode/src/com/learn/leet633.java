package com.learn;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 * <p>
 * 示例1:
 * <p>
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 */
public class leet633 {
    public boolean judgeSquareSum(int c) {
        int a = 0, b = (int) Math.sqrt(c);
        while (a <= b) {
            if ((a * a) + (b * b) == c) {
                return true;
            } else if ((a * a) + (b * b) > c) {
                b--;
            } else {
                a++;
            }
        }
        return false;
    }
}
