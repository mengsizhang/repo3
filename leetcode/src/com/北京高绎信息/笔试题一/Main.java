package com.北京高绎信息.笔试题一;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] arry = sc.nextLine().split(" ");
            int[] nums = new int[arry.length];
            for (int i = 0; i <arry.length ; i++) {
                nums[i]=Integer.parseInt(arry[i]);
            }
            System.out.println(lengthOfNums(nums));
        }
    }

    public static int lengthOfNums(int[] nums) {
        int[] dp= new int[nums.length];
        dp[0]=1;
        int max=dp[0];
        for (int i = 1; i <nums.length ; i++) {
            dp[i]=1;
            for (int j = 0; j <=i-1 ; j++) {
                if(nums[i]>nums[j]&&dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                }
            }
            if(max<dp[i]){
                max=dp[i];
            }
        }
        return max;
    }
}
