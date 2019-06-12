package T_36_二叉搜索树与双向链表;

import com.sun.org.apache.bcel.internal.generic.LADD;

import java.util.Stack;

/**
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */


public class Solution {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode pre = null;
        TreeNode current = pRootOfTree;
        TreeNode root = null;
        Stack<TreeNode> stack = new Stack<>();
        boolean isFirst = true;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            if (isFirst) {
                root = current;
                pre = current;
                isFirst = false;
            } else {
                pre.right = current;
                current.left = pre;
                pre = current;
            }
            current = current.right;

        }
        return root;
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
