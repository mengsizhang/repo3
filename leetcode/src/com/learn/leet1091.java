package com.learn;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class leet1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int m = grid.length, n = grid[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        int pathLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            while (size-- > 0) {
                Pair<Integer, Integer> curr = queue.poll();
                int cr = curr.getKey();
                int cc = curr.getValue();
                if (grid[cr][cc] == 1) {
                    continue;
                }
                if (cr == m - 1 && cc == n - 1) {
                    return pathLength;
                }
                grid[cr][cc] = 1;
                for (int[] d : directions) {
                    int nr=cr+d[0];
                    int nc=cc+d[1];
                    if(nr<0||nr>m-1||nc<0||nc>n-1){
                        continue;
                    }
                    queue.add(new Pair<>(nr,nc));
                }
            }
        }
        return -1;
    }
}
