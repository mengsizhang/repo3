package com.offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * 输入: [1,3,2,6,5]
 * 输出: true
 */
public class offer33 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    //采用递归分治的方法，根据递归判断所有子树的正确性
    public boolean recur(int[] postorder, int i, int j) {
        if (i >= j) {//说明此子树节点数量<=1，不需要判断
            return true;
        }
        int p = i;
        while (postorder[p] < postorder[j]) {//左搜索区间
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[j]) {//右搜索区间
            p++;
        }
        //p=j ： 判断 此树 是否正确。
        //recur(i, m - 1)： 判断 此树的左子树 是否正确。
        //recur(m, j - 1) ： 判断 此树的右子树 是否正确。
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}
