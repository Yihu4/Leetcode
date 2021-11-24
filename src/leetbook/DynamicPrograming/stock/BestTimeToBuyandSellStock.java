package leetbook.DynamicPrograming.stock;

/**
 * LC121 只买卖一次股票
 * @author meteora
 */
public class BestTimeToBuyandSellStock {
    public static void main(String[] args) {
        int[] a = new int[]{ 1, 4, 2, 6};
        System.out.println(maxProfitAg(a));
    }

    public static int maxProfitdp(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];

        // 初始化 dp[i][j]表示当天的现金,初始为0
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            // 比较昨天不持股   和   昨天持股,然后今天卖出的现金大小
            // dp[i - 1][0]       dp[i -1][1] + prices[i]
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 比较昨天持股     和   买入今天股票的现金大小 -- 哪个损失的钱少(股价越便宜)
            // dp[i][1]永远是到现在为止最便宜的股价
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            System.out.println("dp[" + i + "][0]:" + dp[i][0]);
            System.out.println("dp[" + i + "][1]:" + dp[i][1]);
        }
        // 最后返回不持股的最后一天
        return dp[len - 1][0];

    }

    // 优化为一维数组
    public static int maxProfitdpop(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[] dp = new int[2];

        // 初始化 dp[i][j]表示当天的现金,初始为0
        dp[0] = 0;// 因为数组默认是0, 所以这一行可以省略
        dp[1] = -prices[0];

        for (int i = 1; i < len; i++) {
            // 比较昨天不持股   和   昨天持股,然后今天卖出的现金大小
            // dp[i - 1][0]       dp[i -1][1] + prices[i]
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            // 比较昨天持股     和   买入今天股票的现金大小 -- 哪个损失的钱少(股价越便宜)
            // dp[i][1]永远是到现在为止最便宜的股价
            dp[1] = Math.max(dp[1], -prices[i]);
        }
        // 最后返回不持股的最后一天
        return dp[0];
    }
    // 因为只买卖一次,所以等效于在某个最大值之前的最小值买入
    public static int maxProfitAg(int[] prices) {
        if (prices.length==1){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        // dp[i][0]代表第i天不持有股票最多现金(没买或者卖了)
        dp[0][0]=0;
        // dp[i][1]代表第i天持有股票的最多现金(永远为最小值的负数)
        dp[0][1]=-prices[0];

        for (int i = 1; i < prices.length; i++) {
            // 比较昨天不持股, 与昨天持股然后今天卖掉的大小

            dp[i][0] = Math.max(dp[i-1][1]+prices[i],dp[i-1][0]);

            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[prices.length-1][0];
    }

    public static int maxProfitFlatAg(int[] prices) {
        // 维护两个变量
        // 当前不持有股票的现金
        int curMax=0;
        // 最小值(当前持有股票的最小值
        int curMin=prices[0];
        for (int i = 1; i < prices.length; i++) {
            curMax= Math.max(curMax,prices[i]-curMin);
            curMin = Math.min(curMin,prices[i]);
        }
        return curMax;
    }


    // 暴力
    public static int maxProfitBL(int[] prices) {
        int len = prices.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                /*if (prices[j] - prices[i] > res) {
                    res = prices[j] - prices[i];
                }*/
                Math.max(res, prices[j] - prices[i]);
            }
        }
        return res;
    }
}