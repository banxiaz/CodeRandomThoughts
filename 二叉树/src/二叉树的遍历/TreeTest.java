package 二叉树的遍历;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int value) {
        val = value;
        left = null;
        right = null;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class TreeTraversal {
    TreeNode root;

    TreeTraversal() {
        this.root = null;
    }

    //       1
    //      / \
    //     2   3
    //    / \   \
    //   4   5   6
    //    \
    //     7
    //前序：1247536   中序：4725136   后序：7452631
    public TreeNode getSimpleTree() {
        TreeNode layer1 = new TreeNode(1);
        TreeNode layer21 = new TreeNode(2);
        TreeNode layer22 = new TreeNode(3);
        TreeNode layer31 = new TreeNode(4);
        TreeNode layer32 = new TreeNode(5);
        TreeNode layer33 = new TreeNode(6);
        TreeNode layer41 = new TreeNode(7);
        //开始构造树
        root = layer1;
        layer1.left = layer21;
        layer1.right = layer22;
        layer21.left = layer31;
        layer21.right = layer32;
        layer22.right = layer33;
        layer31.right = layer41;

        return root;
    }

    public void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.println(root.val);
        inorderTraversal(root.right);
    }

    public void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.println(root.val);
    }

    public List<Integer> preorderTraversal_(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root); //根节点入栈
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop(); //出栈一个元素并保存结果
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right); //先入栈右孩子
            }
            if (node.left != null) {
                stack.push(node.left); //再入栈左孩子
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal_(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root; //总是代表当前节点
        while (cur != null || !stack.isEmpty()) { //这里不一样
            if (cur != null) {
                stack.push(cur);
                cur = cur.left; //左
            } else {
                cur = stack.pop();
                result.add(cur.val); //中
                cur = cur.right; //右
            }
        }
        return result;
    }

    /**
     * 中左右-》中右左-》左右中
     *
     * @param root 根节点
     * @return 后序遍历
     */
    public List<Integer> postorderTraversal_(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>(); //迭代栈
        Stack<TreeNode> temp = new Stack<>(); //暂时搜集结果

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            temp.push(node);
            if (node.left != null) { //左
                stack.push(node.left);
            }
            if (node.right != null) { //右
                stack.push(node.right);
            }
        }

        while (!temp.isEmpty()) {
            result.add(temp.pop().val);
        }
        return result;
        //还有一种方法是：不用第二个栈搜集结果，直接使用result保存结果
        //在返回的时候使用 Collections.reverse(result)，翻转一下结果
    }

    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); //根节点入队
        while (!queue.isEmpty()) {
            List<Integer> itemList = new ArrayList<>(); //用来收集每一层的结果
            int len = queue.size(); //获取当前遍历层次的节点数

            for (int i = 0; i < len; i++) {
                TreeNode tmpNode = queue.poll(); //出队
                itemList.add(tmpNode.val); //tmpNode一定不可能为null

                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left); //左
                }
                if (tmpNode.right != null) {
                    queue.offer(tmpNode.right); //右
                }
            }
            result.add(itemList); //将当前层结果加入到result
        }
        return result;
    }

}

public class TreeTest {
    public static void main(String[] args) {
        TreeTraversal tree = new TreeTraversal();
        TreeNode root = tree.getSimpleTree();

        tree.preOrderTraversal(root);
        tree.inorderTraversal(root);
        tree.postorderTraversal(root);

        List<Integer> res = tree.preorderTraversal_(root);
        System.out.println(res);
        res = tree.inorderTraversal_(root);
        System.out.println(res);
        res = tree.postorderTraversal_(root);
        System.out.println(res);

        List<List<Integer>> res2 = tree.levelOrderTraversal(root);
        System.out.println(res2);

    }
}
