package DataStructure_List;

import java.util.Iterator;
import java.util.function.Consumer;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;


/**
 * 手动实现一个动态数组
 *
 * @param <T>
 */
public class MyArrayList<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int theSize;//MyArrayList的元素个数
    private T[] theList;

    //初始化
    public MyArrayList() {
        doClear();
    }

    public int size() {
        return theSize;
    }

    //清空数组
    public void clear() {
        doClear();
    }

    public void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    /**
     * 获得指定位置的元素
     *
     * @param idx 位置
     */
    public T get(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theList[idx];
    }

    /**
     * set()实现
     *
     * @param idx
     * @param t
     */
    public T set(int idx, T t) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T oldValue = theList[idx];
        theList[idx] = t;
        return oldValue;
    }


    /**
     * 添加新的元素到指定位置
     *
     * @param idx
     * @param t
     */
    public void add(int idx, T t) {
        if (theSize == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = theSize; i > idx; i++) {
            theList[i] = theList[i - 1];
        }
        theList[idx] = t;
        theSize++;
    }

    /**
     * 添加一个元素
     *
     * @param t
     * @return
     */
    public boolean add(T t) {
        add(size(), t);
        return true;
    }

    public T remove(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T oldValue = theList[idx];
        for (int i = idx; i < size(); i++) {
            theList[i] = theList[i + 1];
        }
        theSize--;
        return oldValue;
    }

    //扩大到指定的容量
    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
        T[] oldList = theList;
        theList = (T[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theList[i] = oldList[i];
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator<T>();
    }

    /**
     * 迭代器
     */
    private class ArrayListIterator<T> implements Iterator<T> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < theList.length;
        }

        @Override
        public T next() {
            return (T) theList[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }


    }


}



