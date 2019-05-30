package T_18_2_删除链表中重复的节点;

/**
 * 题目描述:在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode pPreNode = null;
        ListNode pNode = pHead;
        while (pNode != null) {
            ListNode pNext = pNode.next;
            boolean needDel = false;
            if (pNext != null && pNode.val == pNext.val) { //如果当前节点与下一节点值相同，则发生重复
                needDel = true;
            }

            if (!needDel) { //如果没有重复，则往下遍历
                pPreNode = pNode;
                pNode = pNext;
            } else {
                int value = pNode.val;
                ListNode needDelNode = pNode;
                while (needDelNode != null && needDelNode.val == value) {
                    pNext = needDelNode.next;
                    needDelNode = null;
                    needDelNode = pNext;
                }
                if (pPreNode == null) { //没有前置节点说明 从头节点就开始重复了
                    pHead = pNext;
                } else {
                    pPreNode.next = pNext;
                }
                pNode = pNext;
            }

        }
        return pHead;


    }

    public static void main(String[] args) {
        ListNode headNode = new ListNode(1);
        headNode.next = new ListNode(2);
        headNode.next.next = new ListNode(3);
        headNode.next.next.next = new ListNode(3);
        headNode.next.next.next.next = new ListNode(4);
        headNode.next.next.next.next.next = new ListNode(4);
        headNode.next.next.next.next.next.next = new ListNode(5);

        Solution s = new Solution();
        s.deleteDuplication(headNode);
        while (headNode != null) {
            System.out.print(headNode.val+" ");
            headNode = headNode.next;
        }
    }
}
