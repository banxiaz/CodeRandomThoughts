package Tree;


public class TreeTraversal {
    public TreeTraversal(){}

    //前序：1247536   中序：4725136   后序：7452631
    public static TreeNode getSimpleTree() {
        TreeNode layer1 = new TreeNode(1);
        TreeNode layer21 = new TreeNode(2);
        TreeNode layer22 = new TreeNode(3);
        TreeNode layer31 = new TreeNode(4);
        TreeNode layer32 = new TreeNode(5);
        TreeNode layer33 = new TreeNode(6);
        TreeNode layer41 = new TreeNode(7);
        //开始构造树
        TreeNode root = layer1;
        layer1.left = layer21;
        layer1.right = layer22;
        layer21.left = layer31;
        layer21.right = layer32;
        layer22.right = layer33;
        layer31.right = layer41;

        return root;
    }

    public static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.val);
        inOrderTraversal(root.right);
    }

    public static void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.val);
    }
}
