package com.learn;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 */
public class leet345 {
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] res = new char[s.length()];
        while (i <= j) {
            char s1 = s.charAt(i);
            char s2 = s.charAt(j);
            if(!vowels.contains(s1)){
                res[i++]=s1;
            }else if(!vowels.contains(s2)){
                res[j--]=s2;
            }else{
                res[i++]=s2;
                res[j--]=s1;
            }
        }
        return new String(res);
    }
}
