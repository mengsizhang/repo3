package com.leetcode;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class leet34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            return nums[0] == target ? new int[]{0, 0} : new int[]{-1, -1};
        }
        int start = left_bound(nums, target);
        int end = right_bound(nums, target);
        return new int[]{start, end};
    }

    private int left_bound(int[] nums, int target) {//左闭右开区间，所以在更新右区间时不需要减一，但在更新左区间时需要加一
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;//相等的时候压缩左区间继续寻找最左面等于target的边界
            }
        }
        if (l == nums.length) {//做一下越界判断
            return -1;
        }
        return nums[l] == target ? l : -1;
    }

    private int right_bound(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                l = mid + 1;//相等的时候压缩右区间继续寻找最右面等于target的边界
            }
        }
        if (r == 0) {
            return -1;
        }
        return nums[r - 1] == target ? r - 1 : -1;//因为每次l=mid+1,所以最后l==r退出循环时，mid=l-1即mid=r-1，因为判断条件是nums[mid]==target
    }
}
