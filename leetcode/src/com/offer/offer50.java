package com.offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例:
 * <p>
 * s = "abaccdeff"
 * 返回 "b"
 * <p>
 * s = ""
 * 返回 " "
 */
public class offer50 {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new LinkedHashMap<>();
        char[] ch = s.toCharArray();
        for (Character c : ch) {
            map.put(c, !map.containsKey(c));
        }
        for (Map.Entry<Character,Boolean> d:map.entrySet()) {
            if(d.getValue()){
                return d.getKey();
            }
        }
        return ' ';
    }
}
