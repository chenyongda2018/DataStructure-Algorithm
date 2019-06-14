package T_37_序列化二叉树;

/**
 * 题目描述
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 思路:
 * 二叉树的前序遍历
 */
public class Solution {


    /**
     * 序列化二叉树
     *
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("#");
            sb.append(",");
            return sb.toString();
        }
        sb.append(root.val);
        sb.append(",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();

    }

    /**
     * 反序列化二叉树
     */
    int index = -1;

    TreeNode Deserialize(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        index++;
        String[] strings = str.split(",");
        if (!strings[index].equals("#")) {
            int val = Integer.parseInt(strings[index]);
            TreeNode root = new TreeNode(val);
            root.left = Deserialize(str);
            root.right = Deserialize(str);
            return root;
        }
        return null;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tn = s.Deserialize("1,2,4,#,#,#,3,5,#,#,6,#,#");
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