package Chapter_2_链表.T_3_删除链表的中间节点;

public class Solution {


    /**
     * 删除链表的中间结点
     *
     * @param head
     * @return
     */
    public static Node removeMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node cur1 = head;//快指针
        Node midNode = head;//慢指针，指向中间节点
        Node lastOfMid = head;//指向中间节点的前一个结点

        int k = 0;
        while (cur1.next != null) {
            cur1 = cur1.next;
            k++; //每走2步中间节点就变化1个位置
            if (k > 0 && k % 2 == 0) {
                lastOfMid = midNode;
                midNode = midNode.next;
            }
        }
        lastOfMid.next = midNode.next;
        return head;
    }


    /**
     * 删除a/b处的结点
     *
     * @param head
     * @param a
     * @param b
     * @return
     */
    public static Node removeTheNode(Node head, int a, int b) {
        if (head == null || a < b || a < 1) {
            return head;
        }

        int n = 0;
        Node cur = head;
        while (cur.next != null) {
            n++;
            cur = cur.next;
        }

        n = (int)Math.ceil((double)(n*a) / (double)(b));

        if (n == 1) {
            head = head.next;
        }
        if ( n > 1) {
            cur = head;
            while (n-- > 1) {
                cur = cur.next;
            }

            cur = cur.next.next;
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