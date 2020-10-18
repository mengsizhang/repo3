package com.leetcode;

import java.util.Arrays;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class leet56 {
    public int[][] merge(int[][] intervals) {
        //对二维数组进行排序，先按照一维数组的左端点进行排序（升序），如果左端点相等，再按照右端点进行排序（升序）
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] ans = new int[intervals.length][2];
        int i = -1;
        for (int[] interval : intervals) {//遍历这个二维数组
            if (i == -1 || interval[0] > ans[i][1]) {//如果当前结果集数组为空，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，则直接将该区间加入结果集
                ans[++i]=interval;
            }else{
                //否则，将当前区间合并至结果集数组的最后位置
                ans[i][1]=Math.max(ans[i][1],interval[1]);
            }
        }
        //因为res 最初定义时的长度是未合并时区间的个数，用copyof能够削掉多余的空值
        return Arrays.copyOf(ans,i+1);
    }
}
