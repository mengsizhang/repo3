package com.offer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class offer21 {
    /* public int[] exchange(int[] nums) {
         if (nums.length == 0 || nums.length == 1) {
             return nums;
         }
         int i = 0, j = nums.length - 1;
         while (i < j) {
             if (nums[i] % 2 != 0 && nums[j] % 2 == 0) {
                 i++;
                 j--;
             } else if (nums[i] % 2 == 0 && nums[j] % 2 != 0) {
                 swap(nums, i, j);
                 i++;
                 j--;
             } else if (nums[i] % 2 != 0 && nums[j] % 2 != 0) {
                 i++;
             } else {
                 j--;
             }
         }
        return nums;
     }

     public void swap(int[] nums, int i, int j) {
         int temp = nums[i];
         nums[i] = nums[j];
         nums[j] = temp;
     }*/
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1, temp;
        while (i < j) {
            while (i < j && (nums[i] & 1) == 1) {
                i++;
            }
            while (i < j && (nums[i] & 1) == 0) {
                j--;
            }
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}
