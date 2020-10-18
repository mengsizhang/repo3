package com.offer;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 *    2
 * 输出: 4
 */
public class offer54 {
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k=k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.right);

        if (--k == 0) {
            res = node.val;
            return;
        }
        dfs(node.left);

    }
}
