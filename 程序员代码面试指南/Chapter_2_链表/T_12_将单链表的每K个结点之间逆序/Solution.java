package Chapter_2_链表.T_12_将单链表的每K个结点之间逆序;

import java.util.Stack;

public class Solution {
    public Node reverseKNode1(Node head,int K) {
        if(K < 2) return head;
        Node cur = head;
        Node newHead = head;
        Node pre = null;
        Node next = null;
        Stack<Node> stack = new Stack<>();
        while(cur != null) {
            next = cur.next;
            stack.push(cur);
            if(stack.size() == K) {
                pre = resign1(stack,pre,next);
                newHead = newHead == head ? cur : newHead;
            }
            cur = next;
        }
        return newHead;

    }

    public Node resign1(Stack<Node> stack, Node left, Node right) {
        Node cur = stack.pop();
        if(left != null) {
            left.next = cur;
        }
        Node next = null;
        while(!stack.isEmpty()) {
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;
    }
}
class Node {
    Node next;
    Node rand;
    int val;
    public Node(int val) {
        this.val = val;
    }
}