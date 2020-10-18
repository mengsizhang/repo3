package com.leetcode;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class leet28 {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int l = needle.length();
        if (l == 0) {
            return 0;
        }
        int pn = 0;
        while (pn < n - l + 1) {
            while (pn < n - l + 1 && haystack.charAt(pn) != needle.charAt(0)) {
                ++pn;
            }
            int pl = 0, currLen = 0;
            while (pn < n && pl < l && haystack.charAt(pn) == needle.charAt(pl)) {
                ++pn;
                ++pl;
                ++currLen;
            }
            if (currLen == l) {
                return pn - l;
            }
            pn = pn - currLen + 1;
        }
        return -1;
    }
}
