package com.leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class leet5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        String res = s.substring(0, 1);
        int maxLen = 1;
        //其实只需要扩展到length-2的位置即可，因为索引0和索引len-1扩展不出去，所以遍历每个索引以它为中心时，无需遍历最后一个元素
        for (int i = 0; i < len - 1; i++) {
            //奇数个回文字符串,中心位是单个字符
            String oddStr = centerExtend(s, i, i);
            //偶数个回文字符串，中心位是两个相同的字符
            String evenStr = centerExtend(s, i, i + 1);
            String maxLenStr = (oddStr.length() > evenStr.length()) ? oddStr : evenStr;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    private String centerExtend(String s, int left, int right) {
        int i = left;
        int j = right;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
            //跳出循环时i已经是不符合回文字符串的位置，所以要从它右面一个字符开始截取，另外subString方法是左闭右开的
        }
        return s.substring(i+1, j);
    }
}
