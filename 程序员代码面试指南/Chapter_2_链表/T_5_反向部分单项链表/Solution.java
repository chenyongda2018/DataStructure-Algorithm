package Chapter_2_链表.T_5_反向部分单项链表;

public class Solution {

    public static Node reversePart(Node head,int from, int to) {
        //先找到from的前一个结点 fPre和to的后一个结点 tPos
        int len = 0;
        Node node1 = head;
        Node fpre = null;
        Node tpos = null;
        while(node1 != null) {
            len++;
            fpre = len == from -1 ? node1 : fpre;
            tpos = len == to + 1 ? node1 : tpos;
            node1 = node1.next;
        }
        if (from > to || from < 1 || to > len) return head;
        Node next = null;
        //找到反转部分的第一个结点node1
        node1 = fpre == null ? head : fpre.next;
        node1.next = tpos;
        Node node2 = node1.next;
        //进行反转
        while(node2 != tpos) {
            next = node2.next;
            node2.next = node1;
            node2 =next;
            node1 = node2;
        }

        if (fpre != null) {
            fpre.next = node1;
            return head;
        }
        return node1;
    }

}

class Node {
    Node next;
    int val;


    public Node(int val) {
        this.val = val;
    }
}
