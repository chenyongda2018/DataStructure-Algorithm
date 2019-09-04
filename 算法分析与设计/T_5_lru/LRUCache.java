package T_5_lru;

import java.util.HashMap;

public class LRUCache {
    int capcity ;
    private HashMap<Integer,Node> map = new HashMap<>();
    //双向链表的头节点，尾节点
    private Node head = new Node(-1,-1);
    private Node tail = new Node(-1,-1);


    /**
     * 当容量要超过capcity时 , 删除最近最少使用的结点
     * @param capcity
     */
    public LRUCache(int capcity) {
        this.capcity = capcity;
        head.next = tail;
        tail .pre = head;
    }

    public void put(int key, int value) {
        //如果存在, 则更新值
        if(map.containsKey(key)) {
            map.get(key).val = value;
            return;
        }
        //如果容量以满 , 则按照最近最少使用原则删除结点
        if(map.size() == capcity) {
            map.remove(head.next.key);//从哈希表中删除
            head.next = head.next.next;
            head.next.pre = head;
        }
        //如果哈希表中不存在，则放入队尾
        Node newNode = new Node(key,value);
        map.put(key,newNode);
        moveToTail(new Node(key,value));

        Node cur = head.next;


        print();
    }

    private void print() {
        System.out.println();
        Node cur = head.next;
        while(cur!=tail) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node cur = map.get(key);
        //在旧位置删除结点
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        //放到队尾
        moveToTail(cur);
        print();
        return cur.val;
    }

    /**
     * 将结点放到队尾
     * @param node
     */
    private void moveToTail(Node node) {
       node.pre = tail.pre;
       tail.pre = node;
       node.next = tail;
       node.pre.next = node;
    }



    //结点-包括前驱-后继，键值
    private class Node {
        Node pre,next;
        int val,key;

        public Node(int val, int key) {
            this.val = val;
            this.key = key;
            pre = null;
            next = null;
        }
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        lruCache.put(4,4);
        lruCache.put(5,5);
        lruCache.put(6,6);
    }

}


