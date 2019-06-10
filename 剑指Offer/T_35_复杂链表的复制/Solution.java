package T_35_复杂链表的复制;



/**
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空
 */
public class Solution {

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        cloneNodes(pHead);
        connRandomNodes(pHead);
        return divideList(pHead);
    }

    //复制原链表的每一个结点N的N'结点，并位于原结点之后
    public void cloneNodes(RandomListNode pHead) {
        RandomListNode  head = pHead;
        while (head != null) {
            RandomListNode cloneNode = new RandomListNode(head.label);
            cloneNode.next = head.next;
            head.next = cloneNode;
            head = cloneNode.next;
        }
    }

    //设置副本链表之间的random结点关系
    public void connRandomNodes(RandomListNode pHead) {
        RandomListNode head = pHead;
        while (head != null) {
            RandomListNode cloneNode = head.next;
            if (head.random != null) {
                cloneNode.random = head.random.next;
            }
            head = cloneNode.next;
        }
    }

    public RandomListNode divideList(RandomListNode pHead) {
        RandomListNode head = pHead;
        RandomListNode cHead = null;
        RandomListNode cNode = null;

        if (head != null) {
            cHead = cNode = head.next;
            head.next = cNode.next;
            head = head.next;
        }

        while (head != null) {
            cNode.next = head.next;
            cNode = cNode.next;
            head.next = cNode.next;
            head = head.next;
        }

        return cHead;
    }

}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}