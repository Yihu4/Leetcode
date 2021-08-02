package leetbook.queue_stack.summary;

import java.util.LinkedList;
import java.util.Queue;

// LC733 与岛屿问题类似
public class FloodFill {
    static int oldColor;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {

    }

    // dfs
    public static int[][] floodFilldfs(int[][] image, int sr, int sc, int newColor) {
        /*if (image == null || image.length == 0)
            return 0;*/
        oldColor = image[sr][sc];
        if (oldColor != newColor) {
            dfs(image, sr, sc, newColor);
        }
        return image;
    }

    private static void dfs(int[][] image, int i, int j, int newColor) {
        // 边界判定以及
        if (0 <= i && i < image.length && 0 <= j && j < image[0].length && image[i][j] == oldColor) {
            image[i][j] = newColor;
            for (int k = 0; k < 4; k++) {
                dfs(image, i + dx[k], j + dy[k], newColor);
            }
        }
    }

    // bfs
    public static int[][] floodFillbfs(int[][] image, int sr, int sc, int newColor) {
        /*if (image == null || image.length == 0)
            return 0;*/
        oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }
        int n = image.length;
        int m = image[0].length;
        // 创建数组的队列
        Queue<int[]> queue = new LinkedList<int[]>();
        // 加入原始节点
        queue.add(new int[]{sr, sc});
        // 原始节点变色
        image[sr][sc] = newColor;
        // 当队列不为空的时候,延伸
        while (!queue.isEmpty()) {
            // 取出队列中的节点
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (0 <= mx && mx < n && 0 <= my && my < m && image[mx][my] != newColor) {
                    queue.add(new int[]{mx, my});
                    image[mx][my] = newColor;
                }
            }
        }
        return image;

    }
}
