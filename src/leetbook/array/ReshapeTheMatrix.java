package leetbook.array;

/**
 * LC 566
 *
 * @author: Yihu4
 * @create: 2021-11-18 15:03
 */
public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        // 关键
        for (int i = 0; i < r * c; i++) {
            res[i/c][i%c] = mat[i/n][i%n];
        }
        return res;
    }
}
