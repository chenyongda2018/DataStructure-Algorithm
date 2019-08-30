package Chapter_3_二叉树.T_10_AVLTree;

public class Solution {


    /**
     * 插入操作
     *
     * @param root
     * @param key
     * @return
     */
    public AVLNode insert(AVLNode root, int key) {
        AVLNode node = new AVLNode(key, null, null);

        if (root == null) return node;

        if (node.key < root.key) {
            root.left = insert(root.left, key);
        } else if (node.key > root.key) {
            root.right = insert(root.right, key);
        }

        return balance(root);

    }

    public AVLNode remove(AVLNode root, int key) {
        if (root == null) return null;

        if (key > root.key) {
            root.right = remove(root.right, key);
        } else if (key < root.key) {
            root.left = remove(root.left, key);
        } else if (root.left != null && root.right != null) {
            root.key = findMin(root.right).key;
            root.right = remove(root.right, root.key);
        } else {
            root = root.left != null ? root.left : root.right;
        }
        return balance(root);

    }

    public AVLNode findMin(AVLNode node) {
        if (node == null) return null;
        if (node.left == null) return node;
        return findMin(node.left);
    }


    /**
     * 平衡操作
     *
     * @param root
     * @return
     */
    public AVLNode balance(AVLNode root) {
        if (root == null) return null;

        if (height(root.left) - height(root.left) > 1) {
            if (height(root.left.left) >= height(root.left.right)) {
                root = rightRotale(root);
            } else {
                root = lrRotale(root);
            }
        } else if (height(root.right) - height(root.right) > 1) {
            if (height(root.right.right) >= height(root.right.left)) {
                root = leftRotale(root);
            } else {
                root = rlRotale(root);
            }

        }
        root.height = Math.max(root.left.height, root.right.height) + 1;
        return root;
    }


    /**
     * 先右旋再左旋  RL下使用
     *
     * @param root
     * @return
     */
    public AVLNode rlRotale(AVLNode root) {
        root.right = rightRotale(root.right);
        return leftRotale(root);
    }


    /**
     * 先左旋，再右旋， LR时使用
     *
     * @param root
     * @return
     */
    public AVLNode lrRotale(AVLNode root) {
        root.left = leftRotale(root.left);
        return rightRotale(root);
    }

    /**
     * 右旋转 - 当LL情形下使用
     *
     * @param root
     * @return
     */
    public AVLNode rightRotale(AVLNode root) {
        AVLNode node = root.left;
        AVLNode nodeRight = node.right;
        root.left = nodeRight;
        node.right = root;
        node.height = Math.max(node.left.height, node.right.height) + 1;
        root.height = Math.max(root.left.height, root.right.height) + 1;
        return node;
    }

    /**
     * 左旋转 - 当RR情形下使用
     *
     * @param root
     * @return
     */
    public AVLNode leftRotale(AVLNode root) {
        AVLNode node = root.right;
        AVLNode nodeLeft = node.left;
        root.right = nodeLeft;
        node.left = root;
        node.height = Math.max(node.left.height, node.right.height) + 1;
        root.height = Math.max(root.left.height, root.right.height) + 1;
        return node;
    }

    //获取这个节点所在的高度
    public int height(AVLNode node) {
        return node == null ? -1 : node.height;
    }
}


//avl树中的节点
class AVLNode {
    public int key;
    public AVLNode left;
    public AVLNode right;
    public int height;

    public AVLNode(int key, AVLNode left, AVLNode right) {
        this.key = key;
        this.left = left;
        this.right = right;

    }
}


