package basic;

/**
 * LC122 股票最佳买卖时间
 * @author meteora
 */
public class A122 {
    public static void main(String[] args) {
        int[] a = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfitdfs(a));
    }

    /** dfs 暴力*/
    static int res;

    public static int maxProfitdfs(int[] prices) {
        int len = prices.length;
        // 如果只有1个数据,则直接返回
        if (len < 2) {
            return 0;
        }
        res = 0;
        dfs(prices, 0, len, 0, res);
        return res;

    }

    /** status 0 为不持股        1 为持股*/
    public static void dfs(int[] prices, int index, int len, int status, int profit) {
        if (index == len) {
            res = Math.max(res, profit);
            return;
        }
        // 不操作
        dfs(prices, index + 1, len, status, profit);

        // 操作 转换状态
        if (status == 0) {
            // 买入
            dfs(prices, index + 1, len, 1, profit - prices[index]);
        } else {
            // 卖出
            dfs(prices, index + 1, len, 0, profit + prices[index]);
        }
    }
}
