package leetbook.queue_stack.summary;

import java.util.LinkedList;
import java.util.Queue;

// LC542

/**
 * @author meteora
 */
public class Matrix01 {


    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    // 加入所有0的坐标进入队列
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        // 当队列不为空时
        while (!queue.isEmpty()) {
            //取出队列中的坐标
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for (int k = 0; k < 4; k++) {
                int mx = x + dx[k];
                int my = y + dy[k];
                if (0 <= mx && mx < m && 0 <= my && my < n && mat[mx][my] == -1) {
                    mat[mx][my] = mat[x][y] + 1;
                    // 已经有距离的坐标加入队列,当旧的一轮结束之后,新的一轮开始
                    queue.offer(new int[]{mx, my});
                }
            }

        }
        return mat;
    }
}
