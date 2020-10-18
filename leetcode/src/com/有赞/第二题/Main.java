package com.有赞.第二题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[m][2];
        List<Integer> sb = new ArrayList<>();
        List<Integer> xb = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
            if (nums[i][1] == 1) {
                sb.add(nums[i][0]);
            } else {
                xb.add(nums[i][0]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!xb.contains(i) || !sb.contains(i)) {
                res.add(i);
            } else if (nums[0][1] == 0 && i == sb.get(0) && (i == xb.get(0) || !xb.contains(i))) {
                res.add(i);
            }else if(nums[0][1]==1&&!sb.contains(i)){
                res.add(i);
            }
        }
        for (int i = 0; i < res.size(); i++) {
            if (i != res.size() - 1) {
                System.out.print(res.get(i) + " ");
            } else {
                System.out.print(res.get(i));
            }
        }
    }
}
