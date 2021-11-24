package leetbook.BFS_DFS;

import org.junit.Test;

import java.util.*;

/**
 * LC 207
 * @author: Yihu4
 * @create: 2021-11-20 09:23
 */
public class CourseScheduleII {
    @Test
    public void test(){
        int[][] ints = {{3,0}, {3,1}, {4,1}, {4,2}, {5,3}, {5,4}};
        int[][] ints2 = {{1,0}, {0,1}};
        System.out.println(Arrays.toString(findOrder(6, ints)));
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            // 注册所有课程
            inDegree.put(i,0);
        }
        // 所有课程的后续相邻(箭头所指)
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        //result
        List<Integer> result = new ArrayList<>();
        // 遍历所有课程的入度
        for (int[] ints : prerequisites) {
            // 当前课程
            int cur = ints[0];
            // 先修课程
            int pre = ints[1];
            // 增加当前课程的入度
            if (inDegree.containsKey(cur)){
                inDegree.put(cur,inDegree.get(cur)+1);
            }
            if (!adj.containsKey(pre)){
                // 将先修课程之后的课程(当前课程)加入adj
                adj.put(pre,new ArrayList<>());
            }
            // 这个方式可以直接在hashMap往数组中添加元素
            adj.get(pre).add(cur);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int key : inDegree.keySet()) {
            // 入队所有入度为0的课程(可以直接修的课程)
            if (inDegree.get(key)==0){
                queue.offer(key);
                result.add(key);
            }
        }

        while (!queue.isEmpty()){
            int cur = queue.poll();
            // 如果在相邻哈希表中没有该课程
            // 最后一门课不是任何一门课的先修课,adj中没有这个课
            if (!adj.containsKey(cur)){
                continue;
            }
            List<Integer> curAdj = adj.get(cur);
            for (int i : curAdj) {
                // 对每个箭头指向的课程入度减1
                inDegree.put(i,inDegree.get(i)-1);
                // 如果该课程入度为1了(先修课已修完),加入队列
                if (inDegree.get(i)==0){
                    queue.offer(i);
                    result.add(i);
                }
            }
        }
        // 检查是否还有入度不等于0(大于0)的课程(无法完成该课程的先修课)
        for (int key : inDegree.keySet()) {
            if (inDegree.get(key)!=0){
                // 如果有,则返回空
                return new int[] {};
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
