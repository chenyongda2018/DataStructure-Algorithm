package Chapter_2_链表.T_11_复制含有随机指针结点的链表;

import java.util.HashMap;

public class Solution {

    public Node copyListWithRand(Node head) {
        //用哈希表存储<原结点,副本结点>
        HashMap<Node,Node> map = new HashMap<>();
        Node cur = head;

        //创建副本结点,此时副本结点的next,rand都为空
        while(cur!=null) {
            map.put(cur,new Node(cur.val));
        }

        cur = head;

        //为副本结点添加next,rand
        while(cur!=null) {
            map.get(cur).next = cur.next;
            map.get(cur).rand = cur.rand;
        }
        return map.get(head);

    }
}

class Node {
    Node next;
    Node rand;
    int val;
    public Node(int val) {
        this.val = val;
    }
}
