package leetbook.array_string.ddarray;

/**
 * LC 01.08
 *
 * @author: mete0ra
 * @create: 2021-08-04 17:14
 */
public class ZeroMatrix {
    public static void main(String[] args) {

    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 标记行
        boolean[] row = new boolean[m];
        // 标记列
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 两个标记变量
     */
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        // 先看看第一行和第一列会不会在以后赋值为0, 因为以后要用到第一行和第一列储存其他行列的情况
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }
        // 如果其他行列里面有0, 则把对应的第一行第一列的元素赋值为0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 用第一行第一列的0, 把其他行列的元素赋值为0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 按照标记, 如果第一行第一列原本就有0, 则全部赋值为0
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    /**
     * 一个标记变量
     * 第二个方法的优化
     */
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flagCol0 = false;
        for (int i = 0; i < m; i++) {
            // 如果有为0,则标记位为true, 因为先判断,再进行下一个循环,所以没有问题
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
            // 除了第一列,如果,其他有为0的,则那一列的第一个元素以及第一行那一下标的元素都赋值为0
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 倒序, 防止破坏第一行的标记
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {

                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            // 第一行标记
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }
    }

}
