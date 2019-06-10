package T_36_二叉搜索树与双向链表;

import com.sun.org.apache.bcel.internal.generic.LADD;

/**
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */


public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode lastNodeList = null;
        convertList(pRootOfTree, lastNodeList);
        TreeNode head = lastNodeList;
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    public void convertList(TreeNode pRootOfTree, TreeNode lastNodeList) {
        if (pRootOfTree == null) {
            return;
        }
        TreeNode current = pRootOfTree;
        if (current.left != null) {
            convertList(current.left, lastNodeList);
            current.left = lastNodeList;
        }

        if (lastNodeList != null) {
            lastNodeList.right = current;
        }

        lastNodeList = current;

        if (current.right != null) {
            convertList(current.right, lastNodeList);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);

        s.Convert(root);

    }
}


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
