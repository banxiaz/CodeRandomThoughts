package of37序列化二叉树;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        mySerialize(root,stringBuilder);
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
        return myDeserialize(dataList);
    }

    public void mySerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("None,");
            return;
        }
        sb.append(root.val).append(",");
        mySerialize(root.left, sb);
        mySerialize(root.right, sb);
    }

    public TreeNode myDeserialize(List<String> dataList) {
        if (dataList.get(0).equals("None")) {
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        root.left = myDeserialize(dataList);
        root.right = myDeserialize(dataList);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;

        Codec codec = new Codec();
        String res = codec.serialize(root);
        System.out.println(res);
        codec.deserialize(res);
    }
}
