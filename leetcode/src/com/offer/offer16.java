package com.offer;

/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * 说明:
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 */
public class offer16 {
    public double myPow(double x, int n) {
        long N = n;
        return N > 0 ? numPow(x, N) : (1 / numPow(x, N));
    }

    public double numPow(double x, long N) {
        if (N == 0) {
            return 1;
        }
        double y = numPow(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
