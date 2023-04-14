package 二叉搜索树转换为累加树;

import Tree.TreeNode;

public class Solution {
    //中序遍历为：由小到大
    //反中序遍历就是：由大到小 ，然后依次累加
    //使用pre节点记录遍历的前一个节点
    int pre; // 记录前一个节点的数值

    public TreeNode convertBST(TreeNode root) {
        pre = 0;
        traversal(root);
        return root;
    }

    public void traversal(TreeNode cur) {
        if (cur == null) {
            return;
        }
        traversal(cur.right);// 右
        cur.val += pre;        // 中
        pre = cur.val;
        traversal(cur.left); // 左
    }
}
