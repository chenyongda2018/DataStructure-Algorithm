package Chapter_3_二叉树.T_7_寻找二叉树中的最大搜索二叉子树;

import Chapter_3_二叉树.TreeNode;

public class Solution {

    public TreeNode getMaxBST(TreeNode head) {
        return getProcess(head).maxHead;
    }


    public ReturnType getProcess(TreeNode head) {
        if(head == null) return new ReturnType(null,0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        ReturnType lNode = getProcess(head.left);//获取左子树的信息
        ReturnType rNode = getProcess(head.right); //获取右子树的信息

        int min = Math.min(lNode.min,Math.min(head.val,rNode.min)); //获取以当前节点为整树的最小值
        int max = Math.max(rNode.max,Math.max(head.val,rNode.max)); //获取以当前节点为整树的最大值

        int maxBSDSize = Math.max(lNode.maxBSDSize,rNode.maxBSDSize); //获取左右子树二叉搜索子树最大的
        TreeNode maxHead = lNode.maxBSDSize >= rNode.maxBSDSize ? lNode.maxHead : rNode.maxHead;//二叉搜索子树的头节点

        if(lNode.maxHead == head.left && rNode.maxHead == head.right
                && head.val < rNode.min && head.val > lNode.max) {
            maxHead = head; //如果满足条件，此节点本身就是以此节点为整树的最大二叉搜索子树头节点
            maxBSDSize = lNode.maxBSDSize + rNode.maxBSDSize;
        }

        return new ReturnType(maxHead,maxBSDSize,max,min);//整合信息返回
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