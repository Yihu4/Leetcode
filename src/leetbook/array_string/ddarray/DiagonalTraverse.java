package leetbook.array_string.ddarray;

import java.util.Arrays;

/**
 * LC 498
 * https://leetcode-cn.com/problems/diagonal-traverse/solution/dui-jiao-xian-bian-li-fen-xi-ti-mu-zhao-zhun-gui-l/
 * @author: mete0ra
 * @create: 2021-08-04 20:12
 */
public class DiagonalTraverse {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 2,3}, {4, 5,6}, {7,8, 9}};
        System.out.println(Arrays.toString(findDiagonalOrder(mat)));
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[0];
        }

        int m = mat.length;
        int n = mat[0].length;
        int[] nums = new int[m * n];

        // 一维数组下标
        int k = 0;

        boolean flag = true;
        // i 为 x + y
        for (int i = 0; i < m + n; i++) {
            // 当m和n不同时切换
            int pm = flag ? m : n;
            int pn = flag ? n : m;

            // i < pm即起始点在第一行, 当起始点超过第一行了起始点横坐标永远在最后一列
            int x = (i < pm) ? i : pm - 1;
            // i = x + y
            int y = i - x;
            // 一趟
            while (x >= 0 && y < pn) {
                nums[k++] = flag ? mat[x][y] : mat[y][x];
                x--;
                y++;
            }

            flag = !flag;
        }

        return nums;
    }
}
