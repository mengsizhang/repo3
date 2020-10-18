package com.leetcode;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class leet47 {
    //因为该题是要求解所有可能性，所以首先想到用深度优先搜索来做
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);//排序是为了更好的剪枝
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, 0, path, used, res);
        return res;
    }

    /**
     * @param nums
     * @param depth 递归的深度
     * @param path  从某一节点到任意节点的路径
     * @param used  标记某一节点是否被用过
     * @param res   结果集
     */
    private void dfs(int[] nums, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == nums.length) {//递归终止条件
            res.add(new ArrayList<>(path));//path是一个全局变量，只有一份，这里是引用，最后path会回溯到根节点，会为空，所以要每次创建一个对象存储当前path的状态
            return;//退出该层递归
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {//剪枝去重，因为需要剪掉的是当前节点跟上一节点值一样且上一节点刚被撤销的分支，如果只是值相等，但上一节点仍在使用的则无需剪枝
                continue;
            }
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);//将最新选择的节点入栈
            used[i] = true;//并将该节点标记为已使用
            dfs(nums, depth + 1, path, used, res);//递归
            path.removeLast();//回溯到上一层，即撤销对该节点的使用
            used[i] = false;//重置该节点状态
        }
    }
}
