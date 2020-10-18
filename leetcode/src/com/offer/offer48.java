package com.offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class offer48 {
    /*public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int rk = -1;
        for (int i = 0; i < s.length(); ++i) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));//左指针向右移动一格，移除一个字符
            }
            while (rk + 1 < s.length() && !set.contains(s.charAt(rk + 1))) {
                set.add(s.charAt(rk + 1));//右指针不断向右移动
                ++rk;
            }
            maxLen = Math.max(maxLen, rk + 1 - i);
        }
        return maxLen;
    }*/
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) { //1.start不动，end向后移动
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                start = Math.max(map.get(ch)+1, start);//2.当end遇到重复字符，start应该放在上一个重复字符的位置的后一位
            }
            ans = Math.max(ans, end - start + 1);//同时记录最长的长度
            map.put(s.charAt(end), end);
        }
        return ans;
    }

}
