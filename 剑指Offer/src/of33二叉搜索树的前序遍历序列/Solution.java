package of33二叉搜索树的前序遍历序列;

public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        return traversal(preorder, 0, preorder.length - 1);
    }

    public boolean traversal(int[] preorder, int left, int right) {
        //左右子树为空 || 只包含一个节点了
        if (left >= right) {
            return true;
        }

        int p = left;
        while (preorder[p] > preorder[left]) {
            p--;
        }
        int mid = p; //mid左边的都比根节点小
        while (preorder[p] < preorder[left]) {
            p++;
        }
        //在右子树中有比根节点小的数
        if (p != left) {
            return false;
        }

        boolean leftSide = traversal(preorder, left + 1, mid);
        boolean rightSide = traversal(preorder, mid + 1, right);
        return leftSide && rightSide;
    }

    public static void main(String[] args) {
        int[] postorder = {8, 6, 5, 7, 10, 9, 11};
        int[] postorder1 = {8, 6, 5};
        int[] postorder2 = {8, 6, 5, 7};
        int[] postorder3 = {8, 10, 11};
        int[] postorder4 = {8, 10, 9, 11};
        System.out.println(new Solution().verifyPreorder(postorder3));
    }
}
