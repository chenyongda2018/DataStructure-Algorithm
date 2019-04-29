package DataStructure_List;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 手动实现链表,双向链表结构
 */
public class MyLinkList<T> {
    private int theSize = 0;//存储的元素个数
    private int modCount = 0;//记录结构发生改变
    private MyNode<T> beginMark;//头节点 ,头尾节点只是起标记作用，并不存储数据
    private MyNode<T> endMark;//尾节点


    private static class MyNode<T> {
        private T data;//数据
        private MyNode<T> pre;//前驱节点
        private MyNode<T> next;//后驱节点

        public MyNode(T data, MyNode<T> pre, MyNode<T> next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }
    }


    //清空
    public void clear() {
        doClear();
    }

    //重置
    public void doClear() {
        beginMark = new MyNode<>(null, null, null);
        endMark = new MyNode<>(null, beginMark, null);
        beginMark.next = endMark;
        theSize = 0;
        modCount++;
    }

    public int size() {
        return this.theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(T t) {
        add(theSize, t);
        return true;
    }

    public void add(int idx, T t) {
        addBefore(getNode(idx, 0, size()), t);
    }

    /**
     * 在指定元素的前面插入一个元素
     *
     * @param pre
     * @param t
     */
    public void addBefore(MyNode<T> pre, T t) {
        MyNode newNode = new MyNode(t, pre.pre, pre);
        pre.pre.next = newNode;
        pre.pre = newNode;
        theSize++;
        modCount++;
    }

    public T remove(int idx) {
        return (T)remove(getNode(idx));
    }

    private T remove(MyNode<T> t) {
        t.pre.next = t.next;
        t.next.pre = t.pre;
        theSize--;
        modCount++;
        return t.data;
    }

    private MyNode getNode(int idx) {
        return getNode(idx, 0, size() - 1);
    }

    private MyNode<T> getNode(int idx, int lower, int upper) {
        MyNode<T> p;
        if (idx > upper || idx < lower) {
            throw new IndexOutOfBoundsException();
        }
        if (idx < size() / 2) {
            p = beginMark.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = endMark.pre;
            for (int i = size(); i > idx; i--) {
                p = p.pre;
            }
        }

        return p;
    }

    public T get(int idx) {
        return (T) getNode(idx).data;
    }

    public T set(int idx, T t) {
        MyNode oldNode = getNode(idx);
        T oldData = (T) oldNode.data;
        oldNode.data = t;
        return oldData;
    }

    public Iterator<T> iterator() {
        return new LinkListIterator();
    }

    private class LinkListIterator implements Iterator<T> {
        private MyNode<T> currentNode = beginMark.next;
        private int expectedModCount = modCount;
        private boolean okToMoRemove = false;

        @Override
        public boolean hasNext() {
            return currentNode != endMark;
        }

        @Override
        public T next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = currentNode.data;
            currentNode = currentNode.next;
            okToMoRemove = true;
            return data;
        }

        @Override
        public void remove() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToMoRemove) {
                throw new IllegalStateException();
            }

            MyLinkList.this.remove(currentNode.pre); //这里是pre的原因是next()中,currentNode已经指向了下一个
            expectedModCount++;
            okToMoRemove = false;
        }
    }


}
