package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class leet3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<Character>();//HashSet具有唯一性
        int rk = -1;//最长子串的结束位置
        int resLen = 0;
        int len = s.length();
        //采用滑动窗口的思想，依次递增的枚举子串的起始位置，每次从起始位置的下一个字符开始到rk位置的字符串一定可以确保是不重复的
        for (int i = 0; i < len; ++i) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
                resLen=rk-i+1;
            }
            while (rk + 1 < len && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            resLen=Math.max(resLen,rk-i+1);//通过一次次的枚举更新最长的字符串的长度
        }
        return resLen;
    }
}
