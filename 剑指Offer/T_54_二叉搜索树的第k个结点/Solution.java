package T_54_二叉搜索树的第k个结点;

import Chapter_3_二叉树.TreeNode;

import java.util.Stack;
public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot==null || k < 1) return null;
        Stack<TreeNode> s = new Stack<>();
        int j = 0;
        TreeNode cur = pRoot;
        TreeNode kNode = null;
        while(s.size() > 0 || cur!=null ) {
            if(cur!= null) {

                s.push(cur);
                cur = cur.left;
            } else {
                j++;
                TreeNode node = s.pop();
                if(j == k) kNode = node;
                cur = node.right;

            }
        }
        return kNode;
    }


}
