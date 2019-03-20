package DataStructure_Tree;

public class Traversing_Preorder_1 {
    /**
     * 前序遍历 : 根左右
     * 递归实现
     * @param root
     * @return
     */
    public void preorderTraversal_1(TreeNode root) {

        if (root ==null) {
            return ;
        }
        System.out.print(root.val+" ");
        preorderTraversal_1(root.left);
        preorderTraversal_1(root.right);
    }
}
