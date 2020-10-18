package com.offer;

public class offer29 {
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0, left = 0, top = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        while (index < res.length) {
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i];
                if(index==res.length){
                    return res;//只要遍历完了数组所有数据，就不要继续执行下面的for循环了，直接返回res结果集
                }
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                res[index++] = matrix[i][right];
                if(index==res.length){
                    return res;
                }
            }
            right--;
            for (int i = right; i >= left; i--) {
                res[index++] = matrix[bottom][i];
                if(index==res.length){
                    return res;
                }
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                res[index++] = matrix[i][left];
                if(index==res.length){
                    return res;
                }
            }
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[] res = spiralOrder(matrix);
        System.out.println(res);
    }
}
