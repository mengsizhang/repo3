package com.leetcode;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 */
public class leet29 {
    //采用二分法的思想来实现
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);//符号位标志
        int result = 0;
        dividend = -Math.abs(dividend);//为了防止越界，都采用负数来进行运算
        divisor = -Math.abs(divisor);
        while (dividend <= divisor) {
            int temp = divisor;
            int count = 1;
            while (dividend - temp <= temp) {
                temp = temp << 1;//位运算，意思是左移一位，即乘以2的一次方
                count = count << 1;
            }
            dividend -= temp;//通过这个运算跳出外层循环
            result += count;
        }
        return sign ? result : -result;
    }
}
