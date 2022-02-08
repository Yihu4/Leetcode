package leetbook.BFS_DFS;

import java.util.*;

/**
 * @author: Yihu4
 * @create: 2021-12-04 11:29
 */
public class Topology {
    // LC 207 Course Schedule
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 入度表
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
        }
        // 比邻,由先修课为key的比邻表
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        // 遍历入度
        for (int[] tuple : prerequisites) {
            // 当前课
            int cur = tuple[0];
            // 先修课
            int pre = tuple[1];
            // 当前课入度+1
            inDegree.put(cur, inDegree.get(cur) + 1);
            if (!adj.containsKey(pre)) {
                // 如果比邻表中没有,那么创建
                adj.put(pre, new ArrayList<>());
            }

            List<Integer> list = adj.get(pre);
            // 更新邻
            list.add(cur);
            adj.put(pre, list);
            //也可以用adj.get(pre).add(cur)直接更新hashmap中的列表
        }

        // bfs
        Queue<Integer> queue = new LinkedList<>();
        // 入度为0的课进入列表
        for (int key : inDegree.keySet()) {
            if (inDegree.get(key)==0){
                queue.offer(key);
            }
        }
        while (!queue.isEmpty()){
            // 当前的课
            Integer cur = queue.poll();
            // 如果当前入度为0的课不是任何一门课的先修课,那么就可能是最后一门课,直接跳过
            if (!adj.containsKey(cur)){
                continue;
            }
            List<Integer> list = adj.get(cur);
            // 更新入度
            for (int i : list) {
                inDegree.put(i,inDegree.get(i)-1);
                if (inDegree.get(i)==0){
                    queue.offer(i);
                }
            }
        }

        for (int key : inDegree.keySet()) {
            // 遍历入度表,如果有任何一门课的入度不为0,即无法完成该课程的所有先修课,返回false
            if (inDegree.get(key)!=0){
                return false;
            }
        }
        return true;
    }
}
