package leetbook.BFS_DFS;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LC 1034
 * 染当前颜色边界
 * @author: Yihu4
 * @create: 2021-12-07 10:24
 */
public class ColoringABorder {
    int[] dx = new int[]{1, 0, 0, -1};
    int[] dy = new int[]{0, 1, -1, 0};

    /**
     * dfs
     */
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[] visited = new boolean[m * n];
        List<int[]> needChange = new ArrayList<>();
        dfs(grid, visited, row, col, needChange, grid[row][col], m, n);
        for (int[] need : needChange) {
            grid[need[0]][need[1]] = color;
        }
        return grid;
    }

    public void dfs(int[][] grid, boolean[] visited, int row, int col, List<int[]> needChange, int originalColor, int m, int n) {
        visited[row * n + col] = true;
        boolean need = false;
        for (int i = 0; i < 4; i++) {
            int x = row + dx[i];
            int y = col + dy[i];
            //相邻的那个坐标越界了(说明当前坐标就在矩形外边界上), 或不等于原始颜色值(当前坐标相邻点颜色不同, 当前坐标也变成边界了)
            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != originalColor) {
                need = true;
            } else if (!visited[x * n + y]) {
                dfs(grid, visited, x, y, needChange, originalColor, m, n);
            }
        }
        if (need) {
            needChange.add(new int[]{row, col});
        }
    }

    @Test
    public void test() {
        int[][] ints = {{1, 2, 2}, {2, 3, 2}};
        int[][] ints2 = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        colorBorderBFS(ints2, 2, 2, 3);
    }

    public void colorBorderBFS(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m][n];
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> d = new ArrayDeque<>();
        d.addLast(new int[]{row, col});
        while (!d.isEmpty()) {
            int[] poll = d.pollFirst();
            int x = poll[0], y = poll[1], cnt = 0;
            for (int[] di : dirs) {
                int nx = x + di[0], ny = y + di[1];
                // 判断是否越界
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                // 判断是否同色
                if (grid[x][y] != grid[nx][ny]) {
                    continue;
                } else {
                    cnt++;
                }
                // 判断是否已经bfs过
                if (ans[nx][ny] != 0) continue;
                // 只有和当前相同的才会加入下次bfs
                d.addLast(new int[]{nx, ny});
            }
            // 如果四个方向都同色,那么本身颜色就不变
            // 否则染色
            ans[x][y] = cnt == 4 ? grid[x][y] : color;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i][j] == 0) ans[i][j] = grid[i][j];
            }
        }
        int f= 90;
    }
}
