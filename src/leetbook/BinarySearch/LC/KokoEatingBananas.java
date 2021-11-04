package leetbook.BinarySearch.LC;

import org.junit.Test;

/**
 * LC 875
 * @author: Yihu4
 * @create: 2021-11-01 20:55
 */
public class KokoEatingBananas {
    @Test
    public void test(){
        int[] i = new int[]{3,6,7,11};

        System.out.println(minEatingSpeed(i, 8));
    }
    public int minEatingSpeed(int[] piles, int h) {
        int maxVal = 1;
        for (int pile : piles) {
            // 找出最大的值
            maxVal = Math.max(maxVal, pile);
        }

        // 速度最小的时候，耗时最长
        int left = 1;
        // 速度最大的时候，耗时最短
        int right = maxVal;
        while (left < right){
            int mid = left + right >> 1;
            if (calculate(piles,mid) > h){
                // 花的时间多需要加快速度
                left = mid +1;
            }else {
                // 时间少, 减速
                right = mid;
            }
        }
        return left;
    }

    private int calculate(int[] piles, int speed){
        int count = 0;
        for (int i:piles){
            // 在分子上加(除数-1) 变向下取整为向上取整
            count += (i + speed -1)/speed;
        }
        return count;
    }
}
