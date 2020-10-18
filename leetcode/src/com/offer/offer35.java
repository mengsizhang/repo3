package com.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 */
public class offer35 {
    public NNode copyRandomList(NNode head) {
        Map<NNode,NNode> map = new HashMap<>();//创建hashmap
        NNode cur = head ;
        while (cur!=null){
            map.put(cur,new NNode(cur.val));//复制节点值，顺序遍历，存储老结点和新结点(先存储新创建的结点值)
            cur = cur.next;
        }
        cur = head;
        while (cur!=null){
            map.get(cur).next = map.get(cur.next);//新结点next指向同旧结点的next指向
            map.get(cur).random = map.get(cur.random);//复制指向
            cur = cur.next;
        }
        return map.get(head);
    }
}
class NNode {
    int val;
    NNode next;
    NNode random;

    public NNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
