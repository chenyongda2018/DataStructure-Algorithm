package Chapter_2_链表.T_10_给定中间一个结点并从链表中删除;

/**
 * 思路:将下一个结点值覆盖到要删除的结点上,再改变next域
 * @author cyd
 * @date 2019/7/24 9:14
 */
public class Solution {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
