package Chapter_3_二叉树.T_7_寻找二叉树中的最大搜索二叉子树;

import Chapter_3_二叉树.TreeNode;

public class Solution {

    public TreeNode getMaxBST(TreeNode head) {
        return getProcess(head).maxHead;
    }


    public ReturnType getProcess(TreeNode head) {
        if(head == null) return new ReturnType(null,0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        ReturnType lNode = getProcess(head.left);
        ReturnType rNode = getProcess(head.right);

        int min = Math.min(lNode.min,Math.min(head.val,rNode.min));
        int max = Math.max(rNode.max,Math.max(head.val,rNode.max));

        int maxBSDSize = Math.max(lNode.maxBSDSize,rNode.maxBSDSize);
        TreeNode maxHead = lNode.maxBSDSize >= rNode.maxBSDSize ? lNode.maxHead : rNode.maxHead;

        if(lNode.maxHead == head.left && rNode.maxHead == head.right
                && head.val < rNode.min && head.val > lNode.max) {
            maxHead = head;
            maxBSDSize = lNode.maxBSDSize + rNode.maxBSDSize;
        }

        return new ReturnType(maxHead,maxBSDSize,max,min);
    }
}

class ReturnType {
    TreeNode maxHead;
    int maxBSDSize;
    int max;
    int min;

    public ReturnType(TreeNode maxHead, int maxBSDSize, int max, int min) {
        this.maxHead = maxHead;
        this.maxBSDSize = maxBSDSize;
        this.max = max;
        this.min = min;
    }
}