package com.offer;

/**
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 * 示例1:
 *
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class offer42 {
    public int maxSubArray(int[] nums) {
        int sum =0;
        int maxSum = nums[0];
        for (int i = 0; i <nums.length ; i++) {
            if(sum<0){//无增益效果，舍弃
                sum = nums[i];
            }else{//有增益效果，保留
                sum+=nums[i];
            }
            maxSum=Math.max(sum,maxSum);
        }
        return maxSum;
    }
}

