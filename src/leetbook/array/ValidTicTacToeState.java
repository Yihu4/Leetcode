package leetbook.array;

import org.junit.Test;

/**
 * LC 794
 * 判断井字棋是否合法
 * X先下
 *
 * @author: Yihu4
 * @create: 2021-12-09 10:45
 */
public class ValidTicTacToeState {
    @Test
    public void test() {
        String[] strings = {"XXO", "XOX", "OXO"};
        System.out.println(validTicTacToe(strings));
    }

    public boolean validTicTacToe(String[] board) {
        char[][] cs = new char[3][3];
        int sumX = 0;
        int sumO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[i].charAt(j);
                if (c == 'X') sumX++;
                else if (c == 'O') sumO++;
                cs[i][j] = c;
            }
        }
        boolean a = check(cs, 'X');
        boolean b = check(cs, 'O');


        // 如果O比X多
        if (sumX - sumO < 0) {
            return false;
        }
        // 如果数量差大于1
        if (Math.abs(sumX - sumO) > 1) {
            return false;
        }
        // 如果先下的人赢了,但是后下的还下,则错
        if (a && sumX == sumO) {
            return false;
        }
        // 如果后下的赢了,但是先下的还下,则错
        if (b && sumX - sumO == 1) {
            return false;
        }
        return true;
    }

    private boolean check(char[][] cs, char c) {
        for (int i = 0; i < 3; i++) {
            if (cs[i][0] == c && cs[i][1] == c && cs[i][2] == c) return true;
            if (cs[0][i] == c && cs[1][i] == c && cs[2][i] == c) return true;
        }
        int flag1 = 0;
        int flag2 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j && cs[i][j] == c) {
                    flag1++;
                }
                if (i == (2 - j) && cs[i][j] == c) {
                    flag2++;
                }
            }
        }
        return Math.max(flag1, flag2) == 3;
    }
}
