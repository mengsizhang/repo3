package com.offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1:
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 */
public class offer39 {
    public int majorityElement(int[] nums) {
        int vote = 0, x = 0;//定义x是这个数组里的众数
        for (int num : nums) {
            if (vote == 0) {//当发生正负抵消时，剩余数组的众数依然不变，当 票数 vote等于 0 ，则假设 当前数字 num为 众数 x ；
                x = num;
            }
            vote += num == x ? 1 : -1;//若该数是众数，则投票加一，否则减一
        }
        return x;
    }
}
