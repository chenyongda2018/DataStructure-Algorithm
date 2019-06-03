package T_23_链表中环的入口结点;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode meetingNode = meetingNode(pHead);
        if (meetingNode == null) {
            return null;//不存在环
        }
        int loopNodeCount = 1;
        ListNode node = meetingNode;
        while (node.next != meetingNode) {
            node = node.next;
            loopNodeCount++; //记录环节点的个数
        }

        //找出环的入口结点,先让第一个结点走n(环结点个数)步，然后两个结点再每次都走一步，相遇的结点就是入口结点
        node = pHead;
        for (int i = 0; i <loopNodeCount ; i++) {
            node = node.next;
        }
        ListNode node2 = pHead;
        while (node != node2) {
            node = node.next;
            node2 = node2.next;
        }
        return node;
    }

    /**
     * 在有环的情况下找出两指针相遇的结点(此结点在环中)
     * 不存在环时返回null
     *
     * 快指针:一次走2步
     * 慢指针:一次走1步
     * 如果相遇则说明有环
     * @param pHead
     * @return
     */
    public ListNode meetingNode(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode pSlow = pHead;
        if (pSlow == null) {
            return null;
        }
        ListNode pQuick = pSlow.next;
        while (pSlow != null && pQuick != null) {
            if (pSlow == pQuick) {
                return pQuick;
            }

            pSlow = pSlow.next;
            pQuick = pQuick.next;
            if (pQuick != null) {
                pQuick = pQuick.next;
            }
        }
        return null;
    }
}
