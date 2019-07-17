package Chapter_2_链表.T_7_判断链表是否为回文结构;

import java.util.Stack;

import static jdk.nashorn.internal.objects.NativeArray.push;

public class Solution {

    public static boolean isHuiWen(Node head) {
        if (head == null) return false;

        Node cur = head;
        Node right = head.next;
        //cur为快指针,一次走2步,rightOfMid为慢指针.
        while(cur.next !=null && cur.next.next !=null) {
            cur = cur.next.next;
            right = right .next;
        }

        Stack<Integer> stack = new Stack<>();
        while(right != null) {
            stack.push(right.val);
            right = right.next;
        }

        while(!stack.isEmpty()) {
            if(head.val != stack.pop()) return false;
            head = head.next;
        }

        return true;

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        System.out.println(isHuiWen(head));
    }
}

class Node {
    Node next;
    int val;


    public Node(int val) {
        this.val = val;
    }
}
