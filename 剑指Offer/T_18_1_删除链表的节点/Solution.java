package T_18_1_删除链表的节点;

class ListNode {
    int val;
    ListNode pNext;
}

public class Solution {
    public void deleteNode(ListNode pHead, ListNode pDelete) {
        if (pHead == null || pDelete == null) {
            return;
        }
        //如果不是尾节点，则把此节点的下一节点的值赋给这个要被删除的节点，将下一节点赋予null
        if (pDelete.pNext != null) {
            pDelete.val = pDelete.pNext.val;
            pDelete.pNext = pDelete.pNext.pNext;
        } else if (pDelete == pHead) {//如果是头节点，而且是尾节点，则直接赋予null
            pDelete = null;
        } else { //如果是尾节点，而且前面有其他节点
            ListNode node = pHead;
            while (node.pNext != null) {
                if (node.pNext == pDelete) {
                    break;
                }
                node = node.pNext;
            }
            node.pNext = null;
        }

    }
}
