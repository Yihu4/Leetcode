package leetbook.HashTable;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * LC 73
 *
 * @author: Yihu4
 * @create: 2021-11-19 17:00
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row.contains(i)) {
                    matrix[i][j] = 0;
                } else if (col.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    @Test
    public void test() {
        int[][] ints = {{0, 1, 2, 0, 1}, {3, 4, 5, 2, 4}, {1, 3, 1, 5, 2}, {1, 3, 1, 5, 2}, {1, 3, 0, 5, 2}};
        setZeroesRecord(ints);
    }


    // 1.先记录第一行第一列,留着最后用
    // 2.扫描非第一行第一列的位置,如果有0,则把0放到第一行第一列对应的位置
    // 3.再根据第一行第一列的0把其他位置置零
    // 4.最后根据第一步的标记决定第一行第一列的其他是否该置零
    public void setZeroesRecord(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        // 1. 扫描「首行」和「首列」记录「首行」和「首列」是否该被置零
        boolean r0 = false, c0 = false;
        for (int i = 0; i < m; i++) {
            if (mat[i][0] == 0) {
                r0 = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (mat[0][j] == 0) {
                c0 = true;
                break;
            }
        }

        // 2.1 扫描「非首行首列」的位置，如果发现零，将需要置零的信息存储到该行的「最左方」和「最上方」的格子内
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = mat[0][j] = 0;
                }
            }
        }
        // 2.2 根据刚刚记录在「最左方」和「最上方」格子内的置零信息，进行「非首行首列」置零
        for (int j = 1; j < n; j++) {
            if (mat[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    mat[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (mat[i][0] == 0) {
                Arrays.fill(mat[i], 0);
            }
        }

        // 3. 根据最开始记录的「首行」和「首列」信息，进行「首行首列」置零
        if (r0) for (int i = 0; i < m; i++) mat[i][0] = 0;
        if (c0) Arrays.fill(mat[0], 0);
    }
}