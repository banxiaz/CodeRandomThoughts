package UnionFind;

public class UF {
    // 记录连通分量，即孤立的连通个数
    private int count;
    // 节点 x 的父节点是 parent[x]
    private int[] parent;

    //构造函数，n为图的节点总数
    public UF(int n) {
        count = n;
        parent = new int[n];
        // 父节点指针初始指向自己
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    //将p和q连接
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        //如果已经连通
        if (rootP == rootQ) {
            return;
        }
        //如果想要两个节点被连通，则让其中的（任意）⼀个节点的根节点接到另⼀个节点的根节点上
        parent[rootQ] = rootP;
        count--;
    }

    //判断p和q是否连通
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        //如果两个节点连通，则一定有相同的根节点
        return rootP == rootQ;
    }

    //返回图中有多少个连通分量
    public int count() {
        return count;
    }

    //返回某个节点x的根节点x
    private int find(int x) {
        while (x != parent[x]) {
            // 进行路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}
