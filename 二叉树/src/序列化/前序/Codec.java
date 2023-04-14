package 序列化.前序;

import Tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traversal(root, sb);
        return sb.toString();
    }

    public void traversal(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
        }

        sb.append(root.val).append(",");
        traversal(root.left, sb);
        traversal(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
        return myDeserialize(dataList);
    }
    public TreeNode myDeserialize(List<String> dataList) {
        if (dataList.get(0).equals("#")) {
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        root.left = myDeserialize(dataList);
        root.right = myDeserialize(dataList);

        return root;
    }
}
