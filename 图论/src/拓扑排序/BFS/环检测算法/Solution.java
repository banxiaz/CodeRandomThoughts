package 拓扑排序.BFS.环检测算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    //使用入度为0来确保不会重复遍历
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        //创建入度数组
        int[] inDegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            inDegree[to]++;
        }

        // 根据⼊度初始化队列中的节点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            //入度为0，加入队列，表示可以作为起点
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 记录遍历的节点个数
        int count = 0;
        while (!queue.isEmpty()) {
            //其实出队的顺序也是拓扑排序的顺序！！！
            int cur = queue.poll();
            count++;
            for (int next : graph[cur]) {
                //它指向的节点入度减1
                inDegree[next]--;
                //入度为0才能加入队列
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        // 如果所有节点都被遍历过，说明不成环
        return count == numCourses;
    }

    public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }
}
