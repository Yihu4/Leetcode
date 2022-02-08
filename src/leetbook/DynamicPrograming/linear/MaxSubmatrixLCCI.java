package leetbook.DynamicPrograming.linear;

import org.junit.Test;

import java.util.Arrays;

/**
 * LC 17.24
 * 和最大的子矩阵
 *
 * @author: Yihu4
 * @create: 2021-12-01 19:06
 */
public class MaxSubmatrixLCCI {
    @Test
    public void test() {
        int[][] ints = {{-1, 0, -4, -5},{-1, -2, -4, -5}};
        System.out.println(Arrays.toString(getMaxMatrix(ints)));
    }

    // LC 53 转二维
    public int[] getMaxMatrix(int[][] matrix) {
        //保存最大子矩阵的左上角和右下角的行列坐标
        int[] ans = new int[4];
        int N = matrix.length;
        int M = matrix[0].length;
        //记录当前i~j行组成大矩阵的每一列的和，将二维转化为一维
        int[] b = new int[M];
        int sum = 0;//相当于dp[i],dp_i
        int maxsum = Integer.MIN_VALUE;//记录最大值
        int bestr1 = 0;
        int bestc1 = 0;//暂时记录左上角，相当于begin

        for (int i = 0; i < N; i++) {     //以i为上边，从上而下扫描
            //每次更换子矩形上边，就要清空b，重新计算每列的和
            Arrays.fill(b, 0);
            for (int j = i; j < N; j++) {    //子矩阵的下边，从i到N-1，不断增加子矩阵的高
                //一下就相当于求一次最大子序列和
                sum = 0;//从头开始求dp
                for (int k = 0; k < M; k++) {
                    b[k] += matrix[j][k];
                    if (sum > 0) {
                        sum += b[k];
                    } else {
                        // 如果前面区域为负,则自立门户
                        sum = b[k];
                        // 记录左上角坐标
                        bestr1 = i;
                        bestc1 = k;
                    }
                    // 只有sum>maxsum的时候才更新
                    if (sum > maxsum) {
                        maxsum = sum;
                        ans[0] = bestr1;
                        ans[1] = bestc1;
                        ans[2] = j;
                        ans[3] = k;
                    }
                }
            }
        }
        return ans;
    }
}
