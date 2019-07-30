package Chapter_2_链表.T_12_将单链表的每K个结点之间逆序;

import java.util.Stack;

public class Solution {

    /**
     * 方法一:通过一个容量为k个栈，每遍历k个结点，通过栈将这k个结点逆序
     * @param head 链表的头节点
     * @param K    每k个结点
     * @return
     */
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
                //next此时是下一轮结点的第一个结点
                //pre此时是这一轮结点的前一个结点
                pre = resign1(stack,pre,next);//返回下一轮k个结点的前一个结点
                newHead = newHead == head ? cur : newHead; //更新新头部
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