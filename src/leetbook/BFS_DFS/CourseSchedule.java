package leetbook.BFS_DFS;

import org.junit.Test;

import java.util.*;

/**
 * LC 207
 *
 * @author: Yihu4
 * @create: 2021-11-19 20:26
 */
public class CourseSchedule {
    @Test
    public void test() {
        int[][] ints = {{3, 0}, {3, 1}, {4, 1}, {4, 2}, {5, 3}, {5, 4}, {4, 0},{1,3}};
        int[][] ints2 = {{1, 0}, {0, 1}};
        System.out.println(canFinishDFS(6, ints));
    }

    // 有环则失败
    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        // 为所有课程创建比邻表
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        // 标记数组,0表示没有未被dfs访问
        // 1表示本节点启动的dfs访问过了, 一旦遇到了就说明坏了
        // -1表示其他节点启动的dfs访问过了,路径没问题, 不需要再访问了
        int[] flags = new int[numCourses];
        for (int[] cp : prerequisites) {
            // 当前课程的先修课指向当前课程
            adjacency.get(cp[1]).add(cp[0]);
        }
        // 对每个节点进行dfs
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flags, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        // 在这次dfs中,再次遇到了自己(有环)
        if (flags[i] == 1) return false;
        if (flags[i] == -1) return true;
        flags[i] = 1;
        for (Integer j : adjacency.get(i))
            if (!dfs(adjacency, flags, j)) {
                return false;
            }
        flags[i] = -1;
        return true;
    }

    // 拓扑 BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            // 注册所有课程
            inDegree.put(i, 0);
        }
        // 所有课程的后续相邻(箭头所指)
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        // 遍历所有课程的入度
        for (int[] ints : prerequisites) {
            // 当前课程
            int cur = ints[0];
            // 先修课程
            int pre = ints[1];
            // 增加当前课程的入度
            if (inDegree.containsKey(cur)) {
                inDegree.put(cur, inDegree.get(cur) + 1);
            }
            if (!adj.containsKey(pre)) {
                // 将先修课程之后的课程(当前课程)加入adj
                adj.put(pre, new ArrayList<>());
            }
            // 这个方式可以直接在hashMap往数组中添加元素
            adj.get(pre).add(cur);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int key : inDegree.keySet()) {
            // 入队所有入度为0的课程(可以直接修的课程)
            if (inDegree.get(key) == 0) {
                queue.offer(key);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            // 如果在相邻哈希表中没有该课程
            // 则表示该课程没有出现在课程数组的第一个位置(即是先修课,但是不需要先修课程)
            if (!adj.containsKey(cur)) {
                continue;
            }
            List<Integer> curAdj = adj.get(cur);
            for (int i : curAdj) {
                // 对每个箭头指向的课程入度减1
                inDegree.put(i, inDegree.get(i) - 1);
                // 如果该课程入度为1了(先修课已修完),加入队列
                if (inDegree.get(i) == 0) {
                    queue.offer(i);
                }
            }
        }
        // 检查是否还有入度不等于0(大于0)的课程(无法完成该课程的先修课)
        for (int key : inDegree.keySet()) {
            if (inDegree.get(key) != 0) {
                return false;
            }
        }
        return true;
    }
}
