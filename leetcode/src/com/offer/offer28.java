package com.offer;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class offer28 {
    //对称二叉树定义： 对于树中 任意两个对称节点 L 和 R ，一定有：
    //L.val = R.val ：即此两对称节点值相等。
    //L.left.val = R.right.val：即 L的 左子节点 和 R的 右子节点 对称；
    //L.right.val = R.left.val：即 L的 右子节点 和 R的 左子节点 对称。
    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }

    /**
     * recur(L, R) ：
     * 终止条件：
     * 当 L 和 R 同时越过叶节点： 此树从顶至底的节点都对称，因此返回 true；
     * 当 L 或 R中只有一个越过叶节点： 此树不对称，因此返回 false；
     * 当节点 L值不等于 节点 R 值： 此树不对称，因此返回 false ；
     * 递推工作：
     * 判断两节点 L.left和 R.right是否对称，即 recur(L.left, R.right) ；
     * 判断两节点 L.right 和 R.left 是否对称，即 recur(L.right, R.left) ；
     * 返回值： 两对节点都对称时，才是对称树，因此用与逻辑符 && 连接。
     */
    private boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return recur(left.left, right.right) && recur(left.right, right.left);
    }
}
