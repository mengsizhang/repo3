package com.leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 */
public class leet9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int temp = 0;
        int pop = 0;
        while (x != 0) {
            pop = x % 10;
            x = x / 10;
            temp = temp * 10 + pop;
        }
        if (x == temp) {
            return true;
        } else {
            return false;
        }
    }
}
