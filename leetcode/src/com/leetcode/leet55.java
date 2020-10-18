package com.leetcode;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 */
public class leet55 {
    //采用贪心算法的思想，实时维护一个能够到达的最远位置的变量
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int reach = 0;
        for (int i = 0; i < len; i++) {//依次遍历数组中的每个值
            if (i <= reach) {//若当前遍历的数的位置小于等于最远能到达的位置，则比较并更新最远能到达的位置
                reach = Math.max(reach, i + nums[i]);
            }
            if (reach >= len - 1) {//如果最远能到达的位置已经大于等于数组的最后一个数的位置了，则直接返回true
                return true;
            }
        }
        return false;//若遍历结束了还未找到就直接返回false
    }
}
