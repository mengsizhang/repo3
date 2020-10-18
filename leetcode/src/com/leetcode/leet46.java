package com.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class leet46 {
    //因为该题是要求解所有可能性，所以首先想到用深度优先搜索来做
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, 0, path,used, res);
        return res;
    }

    /**
     *
     * @param nums
     * @param depth 递归的深度
     * @param path  从某一节点到任意节点的路径
     * @param used  标记某一节点是否被用过
     * @param res   结果集
     */
    private void dfs(int[] nums, int depth, Deque<Integer> path, boolean[] used,List<List<Integer>> res) {
        if (depth == nums.length) {//递归终止条件
            res.add(new ArrayList<>(path));//path是一个全局变量，只有一份，这里是引用，最后path会回溯到根节点，会为空，所以要每次创建一个对象存储当前path的状态
            return;
        }
        for (int i = 0; i <nums.length ; i++) {
           if(used[i]){
               continue;
           }
           path.addLast(nums[i]);
           used[i]=true;
           dfs(nums,depth+1,path,used,res);//递归
           path.removeLast();//回溯
           used[i]=false;
        }
    }

}
