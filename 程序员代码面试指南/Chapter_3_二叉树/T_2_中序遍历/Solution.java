package Chapter_3_二叉树.T_2_中序遍历;


import Chapter_3_二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()) {
            if(cur!=null) {
                stack.push(cur);
                cur = cur.left;
            }else {
                TreeNode node = stack.pop();
                list.add(node.val);
                cur = node.right;
            }
        }
        return list;
    }
}

