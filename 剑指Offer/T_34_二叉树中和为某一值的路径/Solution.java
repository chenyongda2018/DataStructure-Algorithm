package T_34_二叉树中和为某一值的路径;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

        if (root == null) {
            return resultList;
        }
        ArrayList<Integer> pathList = new ArrayList<>();
        int currentSum = 0;
        findPath(root, target, resultList, pathList, currentSum);
        return resultList;
    }

    public void findPath(TreeNode root,
                         int target,
                         ArrayList<ArrayList<Integer>> resultList,
                         ArrayList<Integer> pathList,
                         int currentSum) {
        currentSum += root.val;
        pathList.add(root.val);

        boolean isLeaf = root.left == null && root.right == null;

        if (isLeaf && currentSum == target) {
            ArrayList<Integer> path = new ArrayList<>();
            for (int num : pathList) {
                path.add(num);
            }
            resultList.add(path);
        }

        if (root.left != null) {
            findPath(root.left, target, resultList, pathList, currentSum);
        }
        if (root.right != null) {
            findPath(root.right, target, resultList, pathList, currentSum);
        }

        pathList.remove(pathList.size() - 1);

    }


    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);

        ArrayList<ArrayList<Integer>> result = s.FindPath(root, 22);

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}