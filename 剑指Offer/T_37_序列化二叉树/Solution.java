package T_37_序列化二叉树;

/**
 * 题目描述
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Solution {


    String Serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        serializeToString(root, sb);
        return sb.toString();

    }

    void serializeToString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
        } else {
            sb.append(root.val + ",");
        }

        serializeToString(root.left, sb);
        serializeToString(root.right, sb);

    }

    TreeNode Deserialize(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String[] strings = str.split(",");
        int index = -1;
        return deserializeStr(strings, index);
    }

    TreeNode deserializeStr(String[] str, int index) {
        index++;
        if (!str[index].equals("#")) {
            int val = Integer.parseInt(str[index]);
            TreeNode root = new TreeNode(val);
            root.left = deserializeStr(str, index);
            root.right = deserializeStr(str, index);
            return root;
        }
        return null;
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