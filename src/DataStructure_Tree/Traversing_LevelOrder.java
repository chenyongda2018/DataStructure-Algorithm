package DataStructure_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traversing_LevelOrder {
    /**
     * 层序遍历-非递归
     * 每一层从左至右遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> levelQueue = new LinkedList<>();
        if (root == null) {
            return resultList;
        }
        levelQueue.add(root);
        while (!levelQueue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int levelNode = levelQueue.size();
            while (levelNode > 0) {
                TreeNode tempNode = levelQueue.poll();
                if (tempNode!= null) {
                    list.add(tempNode.val);
                    levelQueue.add(tempNode.left);
                    levelQueue.add(tempNode.right);
                }
                levelNode--;
            }

            if (!list.isEmpty()) {
                resultList.add(list);
            }
        }

        return resultList;
    }
}
