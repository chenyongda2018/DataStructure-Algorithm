package DataStructure_BinaryTree;

import java.io.Serializable;

/**
 * Created by cyd on 19-4-8.
 */

public class BinaryNode<T extends Comparable> implements Serializable {
    private static final long serialVersionUID = -6477238039299912313L;

    private BinaryNode<T> leftNode;
    private BinaryNode<T> rightNode;

    private T data;

    public BinaryNode(BinaryNode left,BinaryNode right,T data) {
        this.leftNode = left;
        this.rightNode = right;
        this.data = data;
    }

    public BinaryNode(T data) {
        this(null,null,data);
    }

    public boolean isLeaf () {
        return leftNode ==null && rightNode ==null;
    }
}
