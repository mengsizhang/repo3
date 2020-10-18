package com.leetcode;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 */
public class leet58 {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {//从后往前遍历，排除最后一个单词末尾的空格，记录当前位置
            end--;
        }
        if (end < 0) {//如果全为空格，则返回0
            return 0;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {//从记录位置开始继续从后向前遍历，直到找到一个空格结束，记录位置
            start--;
        }
        return end - start;
    }
}
