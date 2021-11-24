package leetbook.DynamicPrograming.stock;

import org.junit.Test;

/**
 * LC 714
 *
 * @author: Yihu4
 * @create: 2021-11-22 21:01
 */
public class BestTimetoBuyandSellStockwithTransactionFee {
    @Test
    public void test(){
        int[] ints = {1, 3, 2, 8, 4, 9};
        System.out.println(maxProfit(ints, 2));
    }
    public int maxProfit(int[] prices, int fee) {
        int res = 0;
        int have = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 不持有股票, 交易要扣钱
            res = Math.max(res,have+prices[i]-fee);
            have = Math.max(have,res-prices[i]);
        }
        return res;
    }
}
