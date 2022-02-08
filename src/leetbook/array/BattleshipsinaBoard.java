package leetbook.array;

/**
 * LC 419
 *
 * @author: Yihu4
 * @create: 2021-12-23 09:31
 */
public class BattleshipsinaBoard {
    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果不是船头,就跳过
                if (i > 0 && board[i - 1][j] == 'X' || j > 0 && board[i][j - 1] == 'X') {
                    continue;
                }
                if (board[i][j] == 'X') {
                    ans++;
                }
            }
        }
        return ans;
    }
}

