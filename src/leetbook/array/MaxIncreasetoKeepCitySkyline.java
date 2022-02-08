package leetbook.array;

import org.junit.Test;

/**
 * LC 807
 * 不改变城市面天际线的情况下,增高其中的建筑高度
 * 求建筑高度最大能增加多少
 * @author: Yihu4
 * @create: 2021-12-13 10:09
 */
public class MaxIncreasetoKeepCitySkyline {
    @Test
    public void test(){
        int[][] ints = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        maxIncreaseKeepingSkyline(ints);
    }
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                row[i]=Math.max(row[i],grid[i][j]);
                col[j]=Math.max(col[j],grid[i][j]);
            }
        }
        int res=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res +=Math.min(row[i],col[j])-grid[i][j];
            }
        }
        return res;
    }
}
