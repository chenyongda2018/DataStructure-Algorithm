package T_26_树的子结构;

/**
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 第一步:先找到在两棵树中相同的结点
 * 第二步:判断以这个结点的子树是不是和B树有相同的结构
 * 递归
 */
public class Solution {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        boolean hasSubtree = false;
        //找出与B树
        while (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                hasSubtree = doesTree1HaveTree2(root1, root2);
            }
            if (!hasSubtree) {
                hasSubtree = HasSubtree(root1.left, root2);
            }
            if (!hasSubtree) {
                hasSubtree = HasSubtree(root1.right, root2);
            }
        }
        return hasSubtree;
    }

    public boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }//说明之前已经遍历到了B树的最后一个结点，之前都已经匹配成功
        if (root1 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }
        //必须左右结点都相等
        return doesTree1HaveTree2(root1.left, root2.left)
                && doesTree1HaveTree2(root1.right, root2.right);
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
