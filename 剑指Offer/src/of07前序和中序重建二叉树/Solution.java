package of07前序和中序重建二叉树;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //假设输入的前序遍历和中序遍历的结果中都不含重复的数字
        //前序 中[左][右] 中序 [左]中[右]
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int n = preorder.length;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return traversal(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    //[0,n-1]
    public TreeNode traversal(int[] preorder, int[] inorder, int preOrderLeft, int preOrderRight, int inOrderLeft, int inOrderRight) {
        if (preOrderLeft > preOrderRight) {
            return null;
        }

        //叶子节点
        int rootValue = preorder[preOrderLeft];
        TreeNode root = new TreeNode(rootValue);
        if (preOrderLeft == preOrderRight) {
            return root;
        }

        //找到根节点在中序遍历中的下标
        int inorderRoot = map.get(rootValue);
        //在中序遍历中求出左子树的长度
        int sizeLeftSubtree = inorderRoot - inOrderLeft;
        //递归构造左右子树
        root.left = traversal(preorder, inorder, preOrderLeft + 1, preOrderLeft + sizeLeftSubtree, inOrderLeft, inorderRoot - 1);
        root.right = traversal(preorder, inorder, preOrderLeft + sizeLeftSubtree + 1, preOrderRight, inorderRoot + 1, inOrderRight);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 25, 17};
        int[] inorder = {9, 3, 15, 20, 7};
        System.out.println(new Solution().buildTree(preorder, inorder));
    }
}
