package leetbook.queue_stack.queue_BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 200
 *
 * @author: mete0ra
 * @create: 2021-08-07 12:07
 */
public class NumIsland {
    public int numIslandsdfs(char[][] grid) {
        //边界条件判断
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //统计岛屿的个数
        int count = 0;
        //两个for循环遍历每一个格子
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //只有当前格子是1才开始计算
                if (grid[i][j] == '1') {
                    //如果当前格子是1，岛屿的数量加1
                    count++;
                    //然后通过dfs把当前格子的上下左右4
                    //个位置为1的都要置为0，因为他们是连着
                    //一起的算一个岛屿，
                    dfs(grid, i, j);
                }
            }
        }
        //最后返回岛屿的数量
        return count;
    }

    // 这个方法会把当前格子以及他邻近的为1的格子都会置为1
    public void dfs(char[][] grid, int i, int j) {
        //边界条件判断，不能越界
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        // 把当前格子置为0，然后再从他的上下左右4个方向继续遍历
        grid[i][j] = '0';
        //上
        dfs(grid, i - 1, j);
        //下
        dfs(grid, i + 1, j);
        //左
        dfs(grid, i, j + 1);
        //右
        dfs(grid, i, j - 1);
    }

    public int numIslandsbfs(char[][] grid) {
        // 边界条件判断
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // 统计岛屿的个数
        int count = 0;
        // 两个for循环遍历每一个格子
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 只有当前格子是1才开始计算
                if (grid[i][j] == '1') {
                    // 如果当前格子是1，岛屿的数量加1
                    count++;
                    // 然后通过bfs把当前格子的上下左右4
                    // 个位置为1的都要置为0，因为他们是连着
                    // 一起的算一个岛屿，
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int x, int y) {
        // 把当前格子先置为0
        grid[x][y] = '0';
        int n = grid.length;
        int m = grid[0].length;
        //使用队列，存储的是格子坐标转化的值
        Queue<Integer> queue = new LinkedList<>();
        // 我们知道平面坐标是两位数字，但队列中存储的是一位数字，
        // 所以这里是把两位数字转化为一位数字
        // 因为m>y 所以可以这样转
        int code = x * m + y;
        // 坐标转化的值存放到队列中
        queue.add(code);
        while (!queue.isEmpty()) {
            // 出队
            code = queue.poll();
            // 在反转成坐标值（i，j）
            int i = code / m;
            int j = code % m;
            // 上
            if (i > 0 && grid[i - 1][j] == '1') {
                // 如果上边格子为1，把它置为0，然后加入到队列中
                // 下面同理
                grid[i - 1][j] = '0';
                queue.add((i - 1) * m + j);
            }
            // 下
            if (i < n - 1 && grid[i + 1][j] == '1') {
                grid[i + 1][j] = '0';
                queue.add((i + 1) * m + j);
            }
            //左
            if (j > 0 && grid[i][j - 1] == '1') {
                grid[i][j - 1] = '0';
                queue.add(i * m + j - 1);
            }
            //右
            if (j < m - 1 && grid[i][j + 1] == '1') {
                grid[i][j + 1] = '0';
                queue.add(i * m + j + 1);
            }
        }
    }


}
