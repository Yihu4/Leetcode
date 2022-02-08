package leetbook.BFS_DFS;

/**
 * LC 1219
 * @author: Yihu4
 * @create: 2022-02-05 17:47
 */
public class PathwithMaximumGold {
    int[][] g;
    boolean[][] visited;
    int m, n;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int getMaximumGold(int[][] grid) {
        g = grid;
        // 高
        m = g.length;
        // 宽
        n = g[0].length;
        visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] != 0) {
                    visited[i][j] = true;
                    res = Math.max(res, dfs(i, j));
                    visited[i][j] = false;
                }
            }
        }
        return res;
    }
    int dfs(int x, int y) {
        int res = g[x][y];
        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (g[nx][ny] == 0) continue;
            if (visited[nx][ny]) continue;
            visited[nx][ny] = true;
            res = Math.max(res, g[x][y] + dfs(nx, ny));
            visited[nx][ny] = false;
        }
        return res;
    }
}
