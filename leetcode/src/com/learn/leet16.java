package com.learn;

import java.util.Arrays;

public class leet16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len; i++) {
            int start = i + 1, end = len - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }
                if (sum < target) {
                    ++start;
                } else if (sum > target) {
                    --end;
                } else {
                    return res;
                }
            }
        }
        return res;
    }
}
