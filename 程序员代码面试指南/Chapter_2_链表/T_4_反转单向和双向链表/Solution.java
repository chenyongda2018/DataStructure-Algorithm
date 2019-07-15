package Chapter_2_链表.T_4_反转单向和双向链表;

public class Solution {

    /**
     * 反转单项链表
     *
     * @param head
     * @return
     */
    public static Node reverseNode(Node head) {
        if (head == null) return head;
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;

    }


    /**
     * 反转双向链表
     * @param head
     * @return
     */
    public static DoubleNode reverseDoubleNode(DoubleNode head) {

        if (head == null) return head;

        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.last = next;
            head.next = pre;
            pre = head;
        }

        return pre;
    }

}

class Node {
    Node next;
    int val;


    public Node(int val) {
        this.val = val;
    }
}

class DoubleNode {
    int val;
    DoubleNode next;
    DoubleNode last;

    DoubleNode(int val) {
        this.val = val;
    }

}
