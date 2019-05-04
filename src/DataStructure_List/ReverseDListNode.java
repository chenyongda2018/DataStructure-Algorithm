package DataStructure_List;

class DListNode {
    int val;
    DListNode next;
    DListNode pre;

    DListNode(int val) {
        this.val = val;
        next = null;
        pre = null;
    }
}

/**
 * 反转双向链表
 */
public class ReverseDListNode {

    public static DListNode reverseDListNode(DListNode head) {
        DListNode curr = null;
        while (head != null) {
            DListNode next = head.next;
            head.next = curr;
            head.pre = next;
            curr = head;
            head = next;
        }
        return curr;
    }


    public static void main(String[] args) {
        //反转前 1 2 3
        DListNode head = new DListNode(1);
        DListNode secNode = new DListNode(2);head.next = secNode; secNode.pre = head;
        DListNode thdNode = new DListNode(3);secNode.next = thdNode;thdNode.pre = secNode;

        head = reverseDListNode(head);
        //反转后 3 2 1
        while (head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}
