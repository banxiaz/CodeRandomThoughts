package 二叉树的最近公共祖先;

import Tree.TreeNode;

public class Solution {
    //如果找到一个节点，发现左子树出现结点p，右子树出现节点q，或者 左子树出现结点q，右子树出现节点p，那么该节点就是节点p和q的最近公共祖先。
    //题目的本质就是在左子树找p，右子树找q，或者在右子树找p，左子树找q，两个都找到了，当前节点就是最近公共祖先
    //递归函数：在root树中查找是否有节点p或者q或者公共祖先，有的话，返回找到的节点；没有的话，返回null
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == q || root == p || root == null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //如果左右都不为空的话，表示找到了，并且公共节点就是root
        if (left != null && right != null) {
            return root;
        }
        //找到了，而且是从右子树中找到的，把这个结果向上面传递
        else if (left == null && right != null) {
            return right;
        }
        //找到了，而且是从左子树中找到的，把这个结果向上面传递
        else if (left != null && right == null) {
            return left;
        }
        //遍历完整棵树都没找到，那就真的没找到
        else return null;
    }
}
