package com.leetcode;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class leet15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listArry = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);//满足a<=b<=c时，才不会输出重复元素数组，所以先排序
        for (int first = 0; first < len; ++first) {
            if (first > 0 && nums[first] == nums[first - 1]) {//同时，对于每一重循环而言，相邻两次枚举的元素不能相同，否则也会造成重复。
                continue;
            }
            int target = -nums[first];
            int third = len - 1;//因为数组此时有序，所以随着二重循环的数增大，和为零，所以三重循环的数一定越来越小才可能存在，所以将第三个数从数组最右侧开始
            for (int second = first + 1; second < len; ++second) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                if (second == third) {//如果指针重合，随着 b 后续的增加，就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    listArry.add(list);
                }
            }
        }
        return listArry;
    }
}
