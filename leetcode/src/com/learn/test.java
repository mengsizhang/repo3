package com.learn;

public class test {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(m, n, k, 0, 0, visited);
    }

    public int dfs(int m, int n, int k, int i, int j, boolean[][] visited) {
        if (i >= m || j >= n || visited[i][j] || getSum(i) + getSum(j) > k) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(m, n, k, i + 1, j, visited) + dfs(m, n, k, i, j + 1, visited);
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
