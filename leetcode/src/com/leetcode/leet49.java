package com.leetcode;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
public class leet49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        //维护一个哈希表，让key等于一个已排序的字符串，值是一个之前输入的字符串列表，且该字符串排好序之后等于key
        Map<String, List> map = new HashMap<String, List>();
        for (String str : strs) {
            char[] arryStr = str.toCharArray();//将每个字符串转化为一个char数组
            Arrays.sort(arryStr);//对数组中的元素进行排序
            String key = String.valueOf(arryStr);//并将排好序的数组转为String字符串
            if (!map.containsKey(key)) {//若当前哈希表里没有该key，就put进去一个，并在value处创建一个空的链表
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);//然后通过key值将原来的字符串添加到该列表
        }
        return new ArrayList(map.values());//将哈希表的value聚合到一个list 集合中
    }
}
