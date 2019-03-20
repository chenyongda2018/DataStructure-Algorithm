package DataStructure_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversing_Preorder_2 {

    /**
     * 前序遍历_非递归实现
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal_2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        stack.push(root);//先将根节点入栈
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                list.add(node.val);//将弹出的栈顶元素的值加入list
                //这里先入栈右孩子，再入左孩子是因为保证左孩子比右孩子先弹出栈。以保证根左右的遍历顺序。
                stack.push(node.right);
                stack.push(node.left);
            }
        }

        return list;

    }
}
