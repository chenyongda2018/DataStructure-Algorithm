package Chapter_3_二叉树.T_6_判断二叉树是否为平衡二叉树;

import Chapter_3_二叉树.TreeNode;

public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root)!=-1;

    }

    public int getDepth(TreeNode node) {
        if(node == null) return 0;
        int left = getDepth(node.left);//左子树的高度
        if(left == -1) return left; //如果左子树不是平衡二叉树，则不继续遍历，直接返回
        int right = getDepth(node.right); //右子树的高度
        if(right == -1) return right;
        return Math.abs(left-right) > 1 ? -1 : 1+Math.max(left,right); //不是平衡二叉树返回-1,是则返回结点的深度.
    }
}
