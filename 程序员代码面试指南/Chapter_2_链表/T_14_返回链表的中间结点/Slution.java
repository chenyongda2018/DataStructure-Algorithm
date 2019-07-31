package Chapter_2_链表.T_14_返回链表的中间结点;



public class Slution {
    public Node middleNode(Node head) {
        if(head == null) return null;
        Node n1 = head;
        Node n2 = head;

        while(n1.next!=null && n1.next.next!=null){
            n1 = n1.next.next;
            n2 = n2.next;
        }
        if(n1.next!=null){
            return n2.next;
        }
        return n2;

    }
}
class Node {
    Node next;
    int val;
    public Node(int val) {
        this.val = val;
    }
}