package Chapter_3_二叉树.T_9_返回指定结点的后继节点;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class Solution {
    //思路 : 若结点有右子树，则返回右子树的最左结点
    //若没有右子树，判断此节点是不是父节点的左孩子，是的话，返回父节点，不是的话，一直往上找是父节点的左孩子的结点。返回结点的父节点

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        if (pNode.right != null) {
            return getMostLeft(pNode.right);
        } else {
            TreeLinkNode p = pNode.next;
            while (p != null && p.left != pNode) {
                pNode = p;
                p = pNode.next;
            }
            return p;
        }
    }

    public TreeLinkNode getMostLeft(TreeLinkNode node) {
        if (node == null) return node;
        while (node.left != null) node = node.left;
        return node;
    }


}
