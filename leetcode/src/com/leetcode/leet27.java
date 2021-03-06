package com.leetcode;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * <p>
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * <p>
 * 注意这五个元素可为任意顺序。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class leet27 {
            public int removeElement(int[] nums, int val) {
            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != val) {
                    nums[i++] = nums[j];
                }
            }
            return i;
        }
/*    因为返回元素的顺序可以任意，所以也可以采用迭代法
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
          if(nums[i]==val){
              nums[i]=nums[n-1];
              n--;
          }else{
              i++;
          }
        }
        return n;
    }*/
}
