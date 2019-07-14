package Chapter_2_链表.T_1_打印2个链表的公共部分;

public class Node {
    Node next;
    int val;

    public Node(int val) {
        this.val = val;
    }


    /**
     * 从2个节点的头节点开始往后遍历
     * 如果node1的值小于node2的值，则第一个节点向后遍历
     * 如果node2的值小于node1的值，则第二个节点向后遍历
     * 当node1 的值等于 node2的值，则打印
     * @param node1
     * @param node2
     */
    public static void printCommonPart(Node node1, Node node2) {
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                node1 = node1.next;
            } else if (node1.val > node2.val) {
                node2 = node2.next;
            } else {
                System.out.print(node1.val+" ");
                node1 = node1.next;
                node2 = node2.next;
            }
        }
    }
}
