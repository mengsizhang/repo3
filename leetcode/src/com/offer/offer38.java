package com.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 */
public class offer38 {
    public String[] permutation(String s) {
        int len = s.length();
        if (len == 0) {
            return new String[0];
        }
        List<String> res = new ArrayList<>();
        boolean[] used = new boolean[s.length()];
        StringBuilder path = new StringBuilder();
        char[] str = s.toCharArray();
        Arrays.sort(str);
        dfs(str, s.length(), 0, used, path, res);
        return res.toArray(new String[0]);
    }

    public void dfs(char[] str, int len, int depth, boolean[] used, StringBuilder path, List<String> res) {
        if (depth == len) {
            res.add(path.toString());
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                if (i > 0 && str[i] == str[i - 1] && !used[i - 1]) {//排除重复的可能
                    continue;
                }
                used[i] = true;
                path.append(str[i]);
                dfs(str, len, depth + 1, used, path, res);
                path.deleteCharAt(path.length() - 1);
                used[i] = false;
            }
        }
    }
}
