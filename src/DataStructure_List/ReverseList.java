package DataStructure_List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

/**
 * 反转单链表
 */
public class ReverseList {

    private static ListNode reverseSingleList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;//先取出当前节点的下一个元素
            head.next = pre; //改变当前节点的next域
            pre = head;// pre代表反转链表的头节点,更新
            head =next;//继续下一个节点
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode secNode = new ListNode(2);
        ListNode thdNode = new ListNode(3);
        head.next = secNode;
        secNode.next = thdNode;
        head = reverseSingleList(head);
        while (head!= null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }



}


