package leetbook.array_string.ddarray;

/**
 * LC 48
 * https://leetcode-cn.com/problems/rotate-matrix-lcci/solution/xuan-zhuan-ju-zhen-by-leetcode-solution/
 * @author: mete0ra
 * @create: 2021-08-04 15:40
 */
public class RotateMatrix {
    public static void main(String[] args) {

    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] matrixCopy = new int[n][n];
        // 旋转到新数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixCopy[j][n - i - 1] = matrix[i][j];
            }
        }
        // 拷贝到旧数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = matrixCopy[i][j];
            }
        }
    }

    // 块旋转


    /**
     * 翻转
     * 水平翻转(上下) + 主对角线翻转
     */

}
