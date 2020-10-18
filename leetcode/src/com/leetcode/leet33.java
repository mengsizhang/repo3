package com.leetcode;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 */
public class leet33 {
    //对于有序数组首先想到二分法，但此题将数组旋转了，所以不是完全有序的，但是我们仍然可以找到有一部分是有序的，所以就将二分法应用在那一部分
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (nums[middle]==target){//时刻判断target 是否是当前middle
                return middle;
            }
            if (nums[middle] >= nums[low]) {//左半部分有序
                if (target >= nums[low] && target < nums[middle]) {//如果target恰好在左半部分，则在前半部分查找
                    high = middle - 1;
                } else {//否则，在后半部分查找
                    low = middle + 1;
                }
            } else {//右半部分有序
                if (target <= nums[high] && target > nums[middle]) {
                    low=middle+1;
                }else{
                    high=middle-1;
                }
            }
        }
        return -1;
    }
}
