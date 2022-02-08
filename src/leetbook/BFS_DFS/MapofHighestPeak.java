package leetbook.BFS_DFS;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC 1765
 *
 * @author: Yihu4
 * @create: 2022-01-29 17:25
 */
public class MapofHighestPeak {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        // 最终结果
        int[][] ans = new int[m][n];
        // 海洋队列
        Deque<int[]> d = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果是海洋
                if (isWater[i][j] == 1) {
                    // 队列添加海洋位置
                    d.addLast(new int[]{i, j});
                }
                // 如果是海洋为0,陆地为-1
                ans[i][j] = isWater[i][j] == 1 ? 0 : -1;
            }
        }
        // 四个方向
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 核心在于由队列控制[每次增加四边]的起始位置,均衡扩展,避免单个点过度扩展
        while (!d.isEmpty()) {
            int[] info = d.pollFirst();
            // 当前海洋的横纵坐标
            int x = info[0];
            int y = info[1];
            // 四个方向  右/左/下/上
            for (int[] di : dirs) {
                // 新坐标
                int nx = x + di[0];
                int ny = y + di[1];
                // 边界,跳过
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                // 如果不是初始陆地,跳过
                if (ans[nx][ny] != -1) {
                    continue;
                }
                ans[nx][ny] = ans[x][y] + 1;
                // 列表增加当前点为新起始点
                d.addLast(new int[]{nx, ny});
            }
        }
        return ans;
    }
}
