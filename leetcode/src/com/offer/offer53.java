package com.offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 */
public class offer53 {
    public int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    public int helper(int[] nums, int tar) {
        int l = 0, r = nums.length - 1;
        while (l<=r){
            int mid = (l+r)/2;
            if(nums[mid]<=tar){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return l;
    }
}
