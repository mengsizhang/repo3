package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class leet22 {
    //做减法
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs("", n, n, res);
        return res;
    }

    /**
     * @param currStr 当前递归得到的结果
     * @param left    左括号还有几个可以使用
     * @param right   右括号还有几个可以使用
     * @param res     结果集
     */

    public void dfs(String currStr, int left, int right, List<String> res) {
        //当递归终止的时候直接把它添加到结果集
        if (left == 0 && right == 0) {
            res.add(currStr);
            return;
        }
        //剪枝（即左括号剩余的数量严格大于右括号剩余数量）
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(currStr + '(', left - 1, right, res);
        }
        if (right > 0) {
            dfs(currStr + ')', left, right - 1, res);
        }
    }
}
