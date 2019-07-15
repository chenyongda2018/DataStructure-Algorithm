package Chapter_2_链表.T_4_反转单向和双向链表;

public class Solution {

    public static Node reverseNode(Node head) {
        if (head == null) return head;
        Node pre = null;
        Node next = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return head;

    }

}

class Node {
    Node next;
    int val;


    public Node(int val) {
        this.val = val;
    }
}
