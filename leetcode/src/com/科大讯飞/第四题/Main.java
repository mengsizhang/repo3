package com.科大讯飞.第四题;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArr=str.split("#");
        char[][] matrix=new char[strArr.length][strArr[0].replace(",","").length()];
        for (int i = 0; i <matrix.length ; i++) {
            String temp=strArr[i].replace(",","");
            for (int j = 0; j <temp.length() ; j++) {
                matrix[i][j]=temp.charAt(j);
            }
        }
        char[] result=spiralOrder(matrix);
        for (int i = 0; i < result.length; i++) {
            if (i == result.length - 1) {
                System.out.print(result[i]);
            }else {
                System.out.print(result[i] + ",");
            }
        }
    }

    public static char[] spiralOrder(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new char[0];
        }
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] marked = new boolean[matrix.length][matrix[0].length];
        char[] res = new char[(matrix.length) * (matrix[0].length)];
        int count = 0, currx = 0, curry = 0, d = 0;
        while (count != res.length) {
            res[count++] = matrix[currx][curry];
            marked[currx][curry] = true;
            int nextx = currx + directions[d][0];
            int nexty = curry + directions[d][1];
            if (nextx < 0 || nextx >= matrix.length || nexty<0||nexty >= matrix[0].length || marked[nextx][nexty]) {
                d = (d + 1) % 4;
                nextx = currx + directions[d][0];
                nexty = curry + directions[d][1];
            }
            currx = nextx;
            curry = nexty;
        }
        return res;
    }
}
