package leetbook.queue_stack.summary;

import java.util.LinkedList;
import java.util.Queue;

// LC542

/**
 * @author meteora
 */
public class Matrix01 {

    public static int[][] updateMatrix(int[][] mat) {
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

    /**
     * https://leetcode-cn.com/problems/01-matrix/solution/2chong-bfs-xiang-jie-dp-bi-xu-miao-dong-by-sweetie/
     * dp
     * 左上，右上，左下，右下?
     * @param mat 0
     * @return 1
     */
    public static int[][] dp(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 1赋值为10000
                dp[i][j] = mat[i][j] == 0 ? 0 : 10000;
            }
        }
        // 从左上角开始
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果当前节点为10000(即未被遍历的1,则变为比较的值+1
                // 如果 行数大于1了, 比较上面的
                if (i - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                // 如果不是第一列, 比较左边的
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        // 从右下角开始? 从左上角开始会遗漏后面的0?
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 如果不是最后一行, 比较下面的
                if (i + 1 < m) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                // 如果不是最后一列, 比较右边的
                if (j + 1 < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }
}
