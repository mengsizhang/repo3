package com.leetcode;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2的31次方, 2的31次方 − 1] 。
 */
public class leet50 {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? numMul(x, N) : (1 / numMul(x, -N));
    }

    public double numMul(double x, long N) {
        if (N == 0) {
            return 1;
        }
        double y = numMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
