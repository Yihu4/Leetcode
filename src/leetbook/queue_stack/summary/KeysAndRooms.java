package leetbook.queue_stack.summary;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LC 841
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 *
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 *
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 *
 * 你可以自由地在房间之间来回走动。
 *
 * 如果能进入每个房间返回 true，否则返回 false。
 *
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
