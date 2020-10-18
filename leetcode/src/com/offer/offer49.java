package com.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 */
public class offer49 {
    //丑数的递推性质： 丑数只包含因子 2, 3, 5 ，因此有 “丑数 == 某较小丑数 × 某因子” （例如：10=5×2）。故此题用动态规划解
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);//因为第n+1个丑数最接近第n个数，所以它是它们中值最小的那个,a、b、c三个索引每循环一次会加一
            if (dp[i] == n2) {
                a ++;
            }
            if (dp[i] == n3) {
                b ++;
            }
            if (dp[i] == n5) {
                c ++;
            }
        }
        return dp[n - 1];//dp[i] 代表第 i + 1个丑数
    }
}
