package of36二叉搜索树与双向链表;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

public class Solution {
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        traversal(root);
        //遍历结束后pre指向尾节点
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void traversal(Node root) {
        if (root == null) {
            return;
        }

        traversal(root.left);
        // 如果pre为空，就说明是第一个节点，头结点，然后用head保存头结点，用于之后的返回
        if (pre == null) {
            head = root;
        } else {    // 如果不为空，那就说明是中间的节点。并且pre保存的是上一个节点，
            // 让上一个节点的右指针指向当前节点
            pre.right = root;
        }
        // 再让当前节点的左指针指向父节点，也就连成了双向链表
        root.left = pre;
        // 更新pre节点
        pre = root;
        traversal(root.right);
    }
}
