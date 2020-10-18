package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 */
public class leet16 {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int diff = 10000;
        Arrays.sort(nums);
        for (int first = 0; first < len; ++first) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < len; ++second) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                for (int third = second + 1; third < len; ++third) {
                    if (third > second + 1 && nums[third] == nums[third - 1]) {
                        continue;
                    }
                    int sum = nums[first] + nums[second] + nums[third];
                    if (sum == target) {
                        return sum;
                    }
                    if (Math.abs(sum - target) < Math.abs(diff - target)) {
                        diff = sum;
                    }
                }
            }
        }
        return diff;
    }
}
