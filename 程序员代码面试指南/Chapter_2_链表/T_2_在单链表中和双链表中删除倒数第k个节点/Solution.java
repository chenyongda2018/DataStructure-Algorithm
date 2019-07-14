package Chapter_2_链表.T_2_在单链表中和双链表中删除倒数第k个节点;

public class Solution {


    /**
     * 在单链表中删除倒数第k个节点
     * 从前往后遍历，每走一步，k-1
     * 当k=0时，说明头节点就正好是倒数第k个节点
     * 当k>0时,说明链表不存在倒数第k个节点
     * k < 0时,再次从走往后遍历，每走一步，k+1,当k = 0时，当前节点就是倒数第k个节点的前一个结点。
     * 利用此节点可以删除倒数第k个结点。
     *
     *
     * 加上注释部分就是刷双链表的解法
     * @param head
     * @param k
     * @return
     */
    public static Node removeLastKthNode(Node head, int k) {
        if (head == null || k < 0) {
            return null;
        }

        Node cur = head;
        while (cur != null) {
            k--;
            cur = cur.next;
        }

        if (k == 0) {
            head = head.next;
            //head.last = null;
        }
        if (k < 0) {
            cur = head;
            while (++k != 0) {
                cur = cur.next;
            }
            Node nextNode = cur.next.next;
            cur.next = nextNode;
            //if (nextNode != null) {
            //    nextNode.last = cur;
            //}
        }

        return head;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        head = removeLastKthNode(head, 3);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }


}

class Node {
    Node next;
    int val;


    public Node(int val) {
        this.val = val;
    }
}