## 剑指Offer题目5-倒着打印链表

题目描述:

输入一个链表的头节点,从尾到头反过来打印每个节点的值

节点定义:

```java
class ListNode {
	public int val;
	public ListNode nextNode;
}

```



解题思路1:

正着遍历链表,并压入栈中,最后遍历栈,因为是后进先出的数据结构,所以会实现倒叙打印链表    

```java
public static void printListReversingly(ListNode headNode) {
        //判断头指针是否为空
        if (headNode == null) {
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        //正着遍历链表,并压入栈中,由于尾节点的下一个是空,所以循环里并没有把尾节点放到栈中
        while (headNode.nextNode!=null) {
            stack.push(headNode);
            headNode = headNode.nextNode;
        }
        stack.push(headNode);//放入最后一个节点

        //遍历栈,因为是后进先出的数据结构,所以会实现倒叙打印链表
        while(stack.size()!=0) {
            System.out.println(stack.pop().val);
        }

    }

    public static void main(String[] args) {
        ListNode headNode = new ListNode(); headNode.val=1;
        ListNode node2 = new ListNode(); node2.val = 2;
        ListNode node3 = new ListNode(); node3.val = 3;
        ListNode node4 = new ListNode(); node4.val = 4;
        ListNode node5 = new ListNode(); node5.val = 5;
        ListNode node6 = new ListNode(); node6.val = 6;
        headNode.nextNode = node2;
        node2.nextNode = node3;
        node3.nextNode = node4;
        node4.nextNode = node5;
        node5.nextNode = node6;

        printListReversingly(headNode);

    }
```



解法2:  

```java
public static void printListRecursive(ListNode headNode) {

        if (headNode != null) {
            if ( headNode.nextNode != null) {
                printListRecursive(headNode.nextNode);
            }
            System.out.println(headNode.val);
        }
    }
```

