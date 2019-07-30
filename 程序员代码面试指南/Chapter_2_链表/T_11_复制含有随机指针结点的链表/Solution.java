package Chapter_2_链表.T_11_复制含有随机指针结点的链表;

import java.util.HashMap;

public class Solution {

    //方法一 : 通过哈希表存储原结点,副本结点
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

    //时间换空间
    public Node copyListWithRand_2(Node head) {

        if(head == null) return null;

        Node cur = head;
        Node next = null;
        //创建副本结点
        while(cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        //为副本结点的rand域赋值
        cur = head;
        while(cur!=null) {
            cur.next.rand = cur.rand == null ? null : cur.rand.next;
            cur = cur.next.next;
        }

        cur = head;
        Node res = cur.next;

        while(cur != null) {
            next = cur.next;
            cur.next = next.next;
            next.next = cur.next.next;
            cur = cur.next;
            next = next.next;
        }

        return res;


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
