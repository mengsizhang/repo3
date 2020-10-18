package com.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class offer32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();//创建一个双端队列即linkedlist,能在添加时选择头插法还是尾插法
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (res.size() % 2 == 0) {//如果是偶数层，则采用尾插法，即从左向右打印，根节点就属于第0层，偶数层
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);//如果是奇数层，则采用头插法，即从右向左打印
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                res.add(list);
            }
        }
        return res;
    }
}
