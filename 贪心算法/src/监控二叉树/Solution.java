package 监控二叉树;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    //要从下往上看，局部最优：让叶子节点的父节点安摄像头，所用摄像头最少，整体最优：全部摄像头数量所用最少！
    /*
        0：该节点无覆盖
        1：本节点有摄像头
        2：本节点有覆盖
        空节点不能是无覆盖（0）的状态，这样叶子节点就要放摄像头了（1）
        空节点也不能是有摄像头的状态（叶子节点2），这样叶子节点的父节点就没有必要放摄像头了，而是可以把摄像头放在叶子节点的爷爷节点上
        所以空节点的状态只能是有覆盖，这样就可以在叶子节点的父节点放摄像头了
        有摄像头的节点再隔两个节点放一个摄像头
     */
    int result;

    public int minCameraCover(TreeNode root) {
        result = 0;
        if (traversal(root) == 0) { // root 无覆盖
            result++;
        }
        return result;
    }

    //共9种情况 00 01 02 10 11 12 20 21 22
    public int traversal(TreeNode cur) {
        // 空节点，该节点有覆盖
        if (cur == null) {
            return 2;
        }
        int left = traversal(cur.left);// 左
        int right = traversal(cur.right);// 右

        // 情况1
        // left == 2 && right == 2 左右节点都有覆盖，那么此时中间节点应该就是无覆盖的状态了
        if (left == 2 && right == 2) {
            return 0;
        }
        // 情况2 左右节点至少有一个无覆盖的情况，则中间节点（父节点）应该放摄像头
        // left == 0 && right == 0 左右节点无覆盖
        // left == 1 && right == 0 左节点有摄像头，右节点无覆盖
        // left == 0 && right == 1 左节点无覆盖，右节点摄像头
        // left == 0 && right == 2 左节点无覆盖，右节点覆盖
        // left == 2 && right == 0 左节点覆盖，右节点无覆盖
        if (left == 0 || right == 0) {
            result++;
            return 1;
        }
        // 情况3 左右节点至少有一个有摄像头，则当前节点为有覆盖
        // left == 1 && right == 2 左节点有摄像头，右节点有覆盖
        // left == 2 && right == 1 左节点有覆盖，右节点有摄像头
        // left == 1 && right == 1 左右节点都有摄像头
        // 其他情况前段代码均已覆盖
        if (left == 1 || right == 1) {
            return 2;
        }

        // 以上代码没有使用else，主要是为了把各个分支条件展现出来，这样代码有助于读者理解
        // 这个 return -1 逻辑不会走到这里。
        return -1;
    }
}
