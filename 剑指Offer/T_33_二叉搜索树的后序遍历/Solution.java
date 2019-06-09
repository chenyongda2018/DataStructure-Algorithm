package T_33_二叉搜索树的后序遍历;


import java.util.Arrays;

/**
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        int length = sequence.length;
        int root = sequence[length - 1];
        int i = 0;
        for ( ;i< length - 1;i++) {
            if (sequence[i] > root) {
                break; //寻找左子树结束
            }
        }
        int j = i; //j为右子树的第一个结点的索引
        for (;j< length - 1;j++) {
            if (sequence[j] < root) {
                return false;
            }
        }

        //检查左子树
        boolean left = true;
        if (i > 0) {
            left = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
        }

        boolean right = true;
        if (i < length - 1) {
            right = VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, length-1));
        }

        return (left && right);

    }
}
