package T_32_3_之字形印二叉树;

import java.util.ArrayList;
import java.util.Stack;


/**
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }

        Stack<TreeNode>[] stack = new Stack[2];

        int current = 0;//0-偶数层 ，1-奇数层
        int next = 1;

        stack[current] = new Stack<>();
        stack[next] = new Stack<>();

        stack[current].push(pRoot);
        ArrayList<Integer> levelList = new ArrayList<>();
        while (!stack[current].empty() || !stack[next].empty()) {
            TreeNode node = stack[current].pop();
            levelList.add(node.val);

            if (current == 0) { //偶数层 先放它的左子节点，再放右子节点
                if (node.left != null) {
                    stack[next].push(node.left);
                }
                if (node.right != null) {
                    stack[next].push(node.right);
                }
            } else {  //奇数层 先放它的右子节点，再放左子节点
                if (node.right != null) {
                    stack[next].push(node.right);
                }
                if (node.left != null) {
                    stack[next].push(node.left);
                }
            }

            if (stack[current].empty()) {
                result.add(levelList);
                levelList = new ArrayList<>();
                current = 1 - current;
                next = 1- next;
            }
        }
        return result;
    }

    public static void main(String[] args) {

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
