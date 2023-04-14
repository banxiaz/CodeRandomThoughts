package of26树的子结构;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    //求子结构而不是子树，子树要包含到叶子节点，而子结构不用
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return isSubTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean isSubTree(TreeNode A, TreeNode B) {
        if (A == null && B != null) {
            return false;
        } else if (A != null && B == null) { //是子结构，而不是子树（与判断子树做区分）
            return true;
        } else if (A == null && B == null) {
            return true;
        } else if (A.val != B.val) {
            return false;
        }

        return isSubTree(A.left, B.left) && isSubTree(A.right, B.right);
    }
}
