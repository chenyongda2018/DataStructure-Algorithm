package Chapter_2_链表.T_15_将搜索二叉树转换成双向链表;

public class Solution {

    /**
     * 时间复杂度0(N) 空间复杂度O(logN)
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        return convertNode(pRootOfTree).start;

    }

    /**
     * ReturnType类型保存了 一个子树转换成的双向链表的头尾两端
     *
     * @param head
     * @return
     */
    public ReturnType convertNode(TreeNode head) {
        if(head == null) return new ReturnType(null,null);

        //获取左子树的双向列表的头尾两短类型
        ReturnType leftList = convertNode(head.left);
        //获取右子树的双向列表的头尾两短类型
        ReturnType rightList = convertNode(head.right);

        //如果左子树的尾节点不为空,则把它右端连向父节点
        if(leftList.end!=null) leftList.end.right = head;
        //父节点连向左子树的尾节点
        head.left = leftList.end;
        //父节点连向右子树的头节点
        head.right =rightList.start;
        //若右子树的头节点不为空,则把它左端连向父节点
        if(rightList.start !=null) rightList.start.left = head;

        //返回以父节点及其子树形成的双链表的头尾结点
        return new ReturnType(leftList.start!=null ? leftList.start : head,
                rightList.end!=null ? rightList.end : head);
    }

}

class ReturnType {
    TreeNode start;
    TreeNode end;
    public ReturnType(TreeNode start,TreeNode end) {
        this.start = start;
        this.end = end;
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