package T_32_从上到下打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */

public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();



        linkedList.add(root);
        while (linkedList.size() > 0) {
            TreeNode node = linkedList.pollFirst();
            list.add(node.val);

            if (node.left != null) {
                linkedList.add(node.left);
            }
            if (node.right != null) {
                linkedList.add(node.right);
            }
        }
        return list;
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
