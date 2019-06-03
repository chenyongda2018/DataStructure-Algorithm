package T_24_反转链表;

/**
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode reverseHead = null;
        ListNode node = head;
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next; //先保存正常顺序下结点的next结点
            if (next == null) {
                reverseHead = node; //遍历到正序的尾部，尾结点作为反转后的头节点
            }
            node.next = pre; //调整结点的next方向
            //指针后移，继续遍历
            pre = node;
            node = next;
        }
        return reverseHead;
    }
}
