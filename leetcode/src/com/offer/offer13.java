package com.offer;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 */
public class offer13 {
    //可以采用dfs或bfs来解决这道问题，由于可达解是个三角形，所以可把搜索方向简化为下方和右方
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(m, n, k, 0, 0, visited);
    }

    public int dfs(int m, int n, int k, int i, int j, boolean[][] visited) {
        if (i >= m || j >= n || visited[i][j] || getSum(i) + getSum(j) > k) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(m, n, k, i + 1, j, visited) + dfs(m, n, k, i, j + 1, visited);//所以相当于(0,0)下方的所有可达解以及它右方的所有可达解
    }

    public int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}
