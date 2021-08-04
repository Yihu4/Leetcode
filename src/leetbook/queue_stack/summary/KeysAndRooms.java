package leetbook.queue_stack.summary;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LC 841
 * @author meteora
 */
public class KeysAndRooms {
    public static void main(String[] args) {
    }

    public static boolean bfs(List<List<Integer>> rooms) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[rooms.size()];
        // 先把第一个房间标记为访问过并加入队列
        visited[0] = true;
        queue.offer(0);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            // 因为visited的存在,每个房间只会出队列一次
            count++;
            // get方法,获取房间里的所有钥匙
            for (int i : rooms.get(x)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        return count == rooms.size();
    }

    static boolean[] visited;
    static int count;

    public static boolean keysAndRoomsDfs(List<List<Integer>> rooms) {
        // 房间数量
        int n = rooms.size();
        count = 0;
        visited = new boolean[n];
        dfs(rooms, 0);
        return count == n;

    }

    public static void dfs(List<List<Integer>> rooms, int x) {
        visited[x] = true;
        count++;
        for (int i : rooms.get(x)) {
            if (!visited[x]) {
                dfs(rooms, i);
            }
        }
    }
}
