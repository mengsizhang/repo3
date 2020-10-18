package com.leetcode;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class leet53 {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];//结果为ans
        int sum = 0;//当前最大连续子序列和为sum
        for (int num : nums) {
            if (sum > 0) {//对数组进行遍历，如果sum>0证明对当前序列有增益效果，则保留sum
                sum += num;
            } else {//若sum<=0,证明sum对结果无增益效果，应舍弃，把sum更新为当前遍历数字
                sum = num;
            }
            ans = Math.max(ans, sum);//每次比较sum和ans的大小，将最大值置为ans
        }
        return ans;
    }
}
