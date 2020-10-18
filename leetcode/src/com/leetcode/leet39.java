package com.leetcode;

import java.util.*;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 */
public class leet39 {
    //采用回溯递归的方式实现
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    /**
     *
     * @param candidates
     * @param residue 剩余数值
     * @param start   本次搜索起始下标
     * @param path    从根节点到任意节点的路径(双端队列)
     * @param res     结果集
     */
    private void dfs(int[] candidates, int residue, int start, Deque<Integer> path, List<List<Integer>> res) {
        if (residue == 0) {//递归终止条件
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (residue - candidates[i] < 0) {//剪枝，对于不合要求的直接跳出该层递归
                break;
            }
            path.addLast(candidates[i]);
            dfs(candidates, residue - candidates[i], i, path, res);//每次设置本次搜索起始下标是防止结果集出现重复，保证更深节点的值永远大于等于上一层节点值
            path.removeLast();//回溯到上一层，继续寻找其它可能路径
        }
    }
}
