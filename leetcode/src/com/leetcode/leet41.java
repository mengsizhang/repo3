package com.leetcode;

import java.util.Arrays;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 */
public class leet41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        if (len == 0 || nums[len - 1] <= 0 || nums[0] > 1) {
            return 1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 1) {
                if (nums[i - 1] >= 1) {
                    return nums[i - 1] + 1;
                } else if (nums[i - 1] > 1 || (nums[i - 1] <= 0 && nums[i] > 1)) {
                    return 1;
                }
            }
        }
        return nums[len - 1] + 1;
    }
}
