package Chapter_3_二叉树.T_8_求二叉树的深度;

import Chapter_3_二叉树.TreeNode;

public class Solution {
    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return 1+Math.max(left,right);
    }
}
