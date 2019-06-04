package T_28_对称的二叉树;

/**
 * 题目描述
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        return isSysmmetrical(pRoot,pRoot );
    }

    boolean isSysmmetrical(TreeNode root1,TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }//必须同时为空 才能对称
        if (root1 == null || root2 == null) {
            return false;
        }//一边为空则不对称

        if(root1.val != root2.val) {
            return false;
        }

        return isSysmmetrical(root1.left,root2.right ) && isSysmmetrical(root1.right,root2.left );
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
