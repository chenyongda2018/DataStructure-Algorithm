package T8_二叉树的下一个节点;

class BinaryTreeNode {
    int val;
    BinaryTreeNode left; //左子节点
    BinaryTreeNode right; //右子节点
    BinaryTreeNode parent; //父节点
}

/**
 * 返回给定的节点在中序遍历中的下一个节点
 * 思路:
 * 1.先找当前节点有没有右子树，有右子树，则它的下一个节点是它的右子树的最左子节点
 * 2.如果此节点没有右子树，且 此节点是它父节点的左子节点，则它的下一个节点为它的父节点
 * 3.如果此节点没有右子树，且 此节点是它父节点的右子节点，则往上找父节点，一直找到一个父节点是左子节点，若存在这样的节点，则下一个节点是此左子节点的父节点
 */
public class Main {

    public static BinaryTreeNode getNext(BinaryTreeNode node) {
        if (node == null) {
            return node;
        }
        BinaryTreeNode tNext = null;
        if (node.right != null) {
            BinaryTreeNode tRight = node.right;
            while (tRight.left != null) {
                tRight = tRight.left;
            }
            tNext = tRight;
        } else if (node.parent != null) {
            BinaryTreeNode parent = node.parent;
            BinaryTreeNode current = node;
            while (parent !=null && current == parent.right) { //如果是此节点是父节点的右子节点
                current = parent;                              //则一直向上寻找直到条件不成立(此节点是父节点的左子节点，或者父节点为空)
                parent = parent.parent;
            }
            tNext = parent;
        }

        return tNext;
    }
}
