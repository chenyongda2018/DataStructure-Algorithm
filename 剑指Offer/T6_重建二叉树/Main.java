package T6_重建二叉树;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by cyd on 19-4-6.
 */
class BinaryTreeNode {
    int val;
    BinaryTreeNode leftNode;
    BinaryTreeNode rightNode;
}
public class Main {
    public BinaryTreeNode getConstructTree(int[] preOrder,int[] inOrder) {
        if (preOrder == null || inOrder == null) {
            return null;
        }
        return constructTree(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1);
    }


    public BinaryTreeNode constructTree(int[] preOrder,int ps,int pe,int[] inOrder,int is,int  ie) {
        if (ps > pe) {
            return  null;
        }
        //在前序数组中找出根节点
        BinaryTreeNode root = new BinaryTreeNode();
        root.val = preOrder[ps];
        root.leftNode = root.rightNode = null;
        int inRootIdx = 0;
        //在中序排列中找到根节点的索引
        while (inRootIdx < ie && inOrder[inRootIdx] != preOrder[ps]) {
            inRootIdx++;
        }
        //没找到根节点
        if (inRootIdx > ie) {
            return  null;
        }

        //递归构造左子树
        root.leftNode = constructTree(preOrder,ps+1,ps+inRootIdx-is,inOrder,is,inRootIdx-1);
        root.rightNode = constructTree(preOrder,ps+inRootIdx-is+1,pe,inOrder,inRootIdx+1,ie);

        return root;
    }

    public static void main(String[] args) {
        int[] pOrder = new int[]{10,6,4,8,14,12,16};
        int[] iOrder = new int[]{4,6,8,10,12,4,16};
        BinaryTreeNode node = new Main().getConstructTree(pOrder,iOrder);
        printTree(node);
    }

    public static void printTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        printTree(root.leftNode);
        System.out.println(root.val+" ");
        printTree(root.rightNode);
    }
}
