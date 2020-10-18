package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class leet17 {
    Map<String, String> phone = new HashMap<String, String>() {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");

        }
    };
    List<String> result = new ArrayList<>();
   //采用回溯的思想，遍历所有可能性
    public void backtrack(String component, String next_digit) {
        if (next_digit.length() == 0) {
            result.add(component);
        } else {
            String digit = next_digit.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                backtrack(component + letter, next_digit.substring(1));//选定前面的字符，然后第二个参数是截取的从当前字符串下标为1开始直到结束的字符串
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {//记得要排除掉输入的字符串为空的情况，这样就直接返回result是[],而不是进入backtrack,返回[""]
            backtrack("", digits);
        }
        return result;
    }
}
