package Chapter_2_链表.T_8_将单向链表按某值按大小划分;

/**
 * 比n大的数放在链表左边,等于的放在中间,大于的放在右边
 */
public class Solution {

    public static Node listPartition1(Node head,int pivot) {
        if(head ==null) return null;
         int n = 0;
        Node node = head;
        while(node.next!=null) {
            n++;
            node = node.next;
        }

        Node[] nodes = new Node[n];
        node = head;
        for(int i = 0; i< n ;i++) {
            nodes[i] = node;
            node = node.next;
        }

        partition(nodes,pivot);

        for(int i = 0; i< n-1;i++) {
            nodes[i].next = nodes[i+1];
        }
        nodes[ n-1].next = null;

        return nodes[0];
    }

    public static void partition(Node[] nodes,int pivot) {
        int start = 0;
        int end = nodes.length-1;
        int index = 0;
        while(index!=end) {
            if(nodes[index].val < pivot) {
                swap(nodes,start++,index++);
            } else if( nodes[index].val > pivot) {
                swap(nodes,end--,index);
            } else {
                index++;
            }
        }
    }

    public static void swap(Node[] nodes,int a,int b) {
        Node temp = nodes[a];
        nodes[a] = nodes[b];
        nodes[b] = temp;
    }


    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(7);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(0);
        listPartition1(head,4);

        Node node = head;
        while (node.next != null) {
            System.out.println(node.val);
            node = node.next;
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
