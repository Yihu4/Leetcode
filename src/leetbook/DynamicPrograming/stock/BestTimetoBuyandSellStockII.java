package leetbook.DynamicPrograming.stock;

import org.junit.Test;

/**
 * LC 122
 * @author: Yihu4
 * @create: 2021-11-22 19:25
 */
// 7,1,5,3,6,4
public class BestTimetoBuyandSellStockII {
    @Test
    public void test(){
        int[] ints = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(ints));
    }
    public int maxProfit(int[] prices) {
        int res = 0;
        int stock = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res,stock+prices[i]);
            // 比问题一多了一个转移,从不持股转移到持股, 这样可以实现多次购买
            stock = Math.max(stock,res-prices[i]);
        }
        return res;
    }
}
