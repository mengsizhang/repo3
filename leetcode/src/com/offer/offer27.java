package com.offer;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * <p>
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 * <p>
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 */
public class offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        //采用递归遍历二叉树，交换每个节点的左子节点和右子节点
        if (root == null) {
            return null;//当遍历到叶子节点时，递归终止，因为它们没有子节点
        }
        TreeNode tmp = root.left;//暂存左子节点在递归右子节点 “root.left = mirrorTree(root.right);root.left=mirrorTree(root.right);”
        // 执行完毕后， root.leftroot.left 的值已经发生改变，此时递归左子节点 mirrorTree(root.left)mirrorTree(root.left) 则会出问题。
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }
}
