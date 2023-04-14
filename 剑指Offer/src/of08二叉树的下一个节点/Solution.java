package of08二叉树的下一个节点;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode father;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    //纯模拟题，真的没意思！
    public int getNextNode(TreeNode pNode) {
        if (pNode == null) {
            return -1;
        }

        //如果一个节点有右子树，它的下一个节点就是右子树中最左节点
        if (pNode.right != null) {
            TreeNode pRight = pNode.right;
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            return pRight.val;
        }
        //如果有父节点
        else if (pNode.father != null) {
            TreeNode pCurrent = pNode;
            TreeNode pParent = pNode.father;
            //如果是父节点的左孩子，下一个节点是父节点
            if (pCurrent == pParent.left) {
                return pParent.val;
            } else {
                //如果是父节点的右孩子
                while (pParent != null && pCurrent == pParent.right) {
                    pCurrent = pParent;
                    pParent = pParent.father;
                }
                if (pParent == null) { //找到最后父节点为空了，那这个节点是最后一个节点，没有下一个节点
                    return -1;
                } else return pParent.val; //一个节点是它父节点的左孩子，下一个节点就是父节点
            }
        }
        //既没右子树，又没父节点，相当于没有右子树的根节点
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root;
    }
}
