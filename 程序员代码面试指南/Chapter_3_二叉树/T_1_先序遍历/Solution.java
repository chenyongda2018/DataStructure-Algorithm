package Chapter_3_二叉树.T_1_先序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    /**
     * 前序-遍历
     */
    public List<Integer> preorderTraversal(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node != null) list.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return list;
    }

}

class Node {
    int val = 0;
    Node left = null;
    Node right = null;

    public Node(int val) {
        this.val = val;

    }

}