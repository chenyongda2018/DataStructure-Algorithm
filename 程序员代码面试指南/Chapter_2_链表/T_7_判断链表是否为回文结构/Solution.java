package Chapter_2_链表.T_7_判断链表是否为回文结构;

import java.util.Stack;

import static jdk.nashorn.internal.objects.NativeArray.push;

public class Solution {

    /**
     * 思想,将长度n的链表的右半边从左到右挨个入栈，再依次弹出与链表开头一个个作比较。O(n)
     * 当n为偶数时,从n/2+1的位置开始入栈
     * 当n为奇数时,从(n+1)/2+1的位置开始入栈.
     * 快指针一次走2步，慢指针一次走1步,当快指针停下时,慢指针将指向右半边开始入栈的位置
     *
     * @param head
     * @return
     */
    public static boolean isHuiWen(Node head) {
        if (head == null) return false;

        Node cur = head;
        Node right = head.next;
        //cur为快指针,一次走2步,rightOfMid为慢指针.
        while (cur.next != null && cur.next.next != null) {
            cur = cur.next.next;
            right = right.next;
        }

        Stack<Integer> stack = new Stack<>();
        while (right != null) {
            stack.push(right.val);
            right = right.next;
        }

        while (!stack.isEmpty()) {
            if (head.val != stack.pop()) return false;
            head = head.next;
        }

        return true;

    }


    public static boolean isHuiWen2(Node head) {
        if (head == null || head.next == null) return false;
        Node node1 = head;
        Node node2 = head;
        while (node2.next != null && node2.next.next != null) {
            node2 = node2.next.next;
            node1 = node1.next;//中间结点
        }

        //开始反转右半边的链表
        Node node3 = node1.next;//右边第一个
        node1.next = null;
        while (node3 != null) {
            node2 = node3.next;
            node3.next = node1;
            node1 = node3;
            node3 = node2;
        }
        //node1 此时是尾节点
        node2 = head;//记录头节点
        node3 = node1;//记录尾节点

        //检查回文结构
        while (node2 != null && node1 != null) {
            if (node2.val == node1.val) {
                node2 = node2.next;
                node1 = node1.next;
            } else {
                return false;
            }
        }
        //node2.next = node1;

        //开始恢复右半边
        //node3是尾节点
        node1 = node3.next;
        node3.next = null;

        while (node1 != null) {
            node2 = node1.next;
            node1.next = node3;
            node1 = node2;
            node3 = node1;
        }
        return true;

    }

    public static void main(String[] args) {
        Node head = new Node(1);

        head.next = new Node(2);
        head.next.next= new Node(2);
        head.next.next.next = new Node(1);
        System.out.println(isHuiWen2(head));
    }
}

class Node {
    Node next;
    int val;


    public Node(int val) {
        this.val = val;
    }
}
