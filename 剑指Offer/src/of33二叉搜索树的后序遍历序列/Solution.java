package of33二叉搜索树的后序遍历序列;

public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return traversal(postorder, 0, postorder.length - 1);
    }

    public boolean traversal(int[] postorder, int left, int right) {
        //左右子树为空 || 只包含一个节点了
        if (left >= right) {
            return true;
        }

        int p = left;
        while (postorder[p] < postorder[right]) {
            p++;
        }
        int mid = p; //mid左边的都比根节点小
        while (postorder[p] > postorder[right]) {
            p++;
        }
        //在右子树中有比根节点小的数
        if (p != right) {
            return false;
        }

        boolean leftSide = traversal(postorder, left, mid - 1);
        boolean rightSide = traversal(postorder, mid, right - 1);
        return leftSide && rightSide;
    }

    public static void main(String[] args) {
        int[] postorder = {9, 11, 10, 8};
        System.out.println(new Solution().verifyPostorder(postorder));
    }
}
