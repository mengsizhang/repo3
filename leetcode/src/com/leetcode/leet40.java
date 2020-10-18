package com.leetcode;

import java.util.*;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 */
public class leet40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    /**
     * @param candidates
     * @param residue    剩余数值
     * @param start      本次搜索起始下标
     * @param path       从根节点到任意节点的路径(双端队列)
     * @param res        结果集
     */
    private void dfs(int[] candidates, int residue, int start, Deque<Integer> path, List<List<Integer>> res) {
        if (residue == 0) {//递归终止条件
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (residue - candidates[i] < 0) {//大剪枝，对于不合要求的直接跳出该层递归
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]) {//小剪枝，如果该数与上一个数数值相等，则继续执行循环，直到找到那个与上次不等的数
                continue;
            }
            path.addLast(candidates[i]);
            dfs(candidates, residue - candidates[i], i + 1, path, res);//每次设置本次搜索起始下标是防止结果集出现重复，保证更深节点的值永远大于等于上一层节点值
            path.removeLast();//回溯到上一层，继续寻找其它可能路径
        }
    }
}
