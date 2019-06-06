package T_32_2_分行从上到下打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 题目描述
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Solution {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        if (pRoot == null) {
            return resultList;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int toBePrint = 1;
        int nextLevel = 0;
        ArrayList<Integer> levelList = new ArrayList<>();
        while (queue.size() > 0) {
            TreeNode node = queue.pollFirst();
            levelList.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevel++;
            }
            toBePrint--;
            if (toBePrint == 0) {
                resultList.add(levelList);
                levelList = new ArrayList<>();
                toBePrint = nextLevel;
                nextLevel = 0;
            }

        }
        return resultList;
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
