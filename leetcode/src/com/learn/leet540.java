package com.learn;

/**
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
 */
public class leet540 {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid % 2 == 1) {//保证lo/mid/hi都在偶数位，让搜索区间为奇数个
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {//如果相同，则我们知道 mid 不是单个元素。且单个元素在 mid 之后。则我们将 lo 设置为 mid + 2。
                lo = mid + 2;
            } else {//如果不是，则我们知道单个元素位于 mid，或者在 mid 之前。我们将 hi 设置为 mid。
                hi = mid;
            }
        }
        return nums[lo];//一旦 lo == hi，则当前搜索空间为 1 个元素，那么该元素为单个元素，我们将返回它。
    }
}
