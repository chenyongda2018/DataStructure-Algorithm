package T_22_链表中倒数第K个节点;

/**
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点
 */
class ListNode {

    int val;

    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}


public class Solution {

    public ListNode FindKthToTail(ListNode head,int k) {
        if( head == null || k == 0) {
            return null;
        }



        ListNode node1 = head;
        ListNode node2 = null;

        for(int i = 0; i< k - 1; i++) {
            if(node1.next != null) {
                node1 = node1.next;
            } else {
                return null;
            }
        }

        node2 = head;

        while (node1.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }

        return node2;
    }
}
