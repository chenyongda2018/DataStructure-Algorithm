package Chapter_2_链表.T_13_合并两个有序链表;

public class Solution {
    public Node mergeTwoLists(Node l1, Node l2) {
        if(l1==null && l2== null) return null;
        Node head = new Node(0);
        Node pre =  head;

        Node h1 = l1;
        Node h2 = l2;
        while(h1!=null && h2!=null) {
            if(h1.val>h2.val) {
                pre.next = h2;
                h2 = h2.next;
            } else {
                pre.next = h1;
                h1 = h1.next;
            }


            pre = pre.next;
        }

        while(h1!=null) {
            pre.next = h1;
            pre = pre.next;
            h1 = h1.next;
        }
        while(h2!=null) {
            pre.next = h2;
            pre = pre.next;
            h2 = h2.next;
        }
        return head.next;
    }
}
class Node {
    Node next;
    int val;
    public Node(int val) {
        this.val = val;
    }
}