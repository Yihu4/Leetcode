package leetbook.queue_stack.summary;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author meteora
 */
public class KeysAndRooms {
    public static void main(String[] args) {

    }

    public static boolean bfs(List<List<Integer>> rooms) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[rooms.size()];
        queue.add(0);
        while (!queue.isEmpty()){
            int x = queue.poll();
            // 因为visited的存在,每个房间只会出队列一次
            count++;
            // get方法,获取房间里的所有钥匙
            for (int i: rooms.get(x)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        return count == rooms.size();
    }

    public static boolean keysAndRoomsDfs(List<List<Integer>> rooms) {

    }
}
