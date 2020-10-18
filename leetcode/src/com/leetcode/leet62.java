package com.leetcode;

import java.util.Arrays;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *示例 1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 */
public class leet62 {
    //此题采用动态规划写，每一个位置的路径数目等于它左边位置路径数目加上它上面位置路径数目
    //对于第一行 dp[0][j]，或者第一列 dp[i][0]，由于都是在边界，所以只能为 1
    //原始动态规划公式为dp[i][j] = dp[i-1][j] + dp[i][j-1]
    //现对它进行优化,改装为一维数组，m代表行，n代表列
    public int uniquePaths(int m, int n) {
       int[] cur = new int[n];
       Arrays.fill(cur,1);//对一维数组初始化，cur[i]=1(0<=i<=n-1)
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                cur[j]=cur[j]+cur[j-1];//对于一维数组来说，对于第i行来说，等号右边的cur[j]就是上一行的第j个数据对应的步数，cur[j-1]就是该行的第j-1处对应的步数
            }
        }
        return cur[n-1];
    }
}
