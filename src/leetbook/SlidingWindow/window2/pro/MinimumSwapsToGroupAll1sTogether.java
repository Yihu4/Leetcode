package leetbook.SlidingWindow.window2.pro;

import org.junit.Test;

/**
 * LC 1151
 * 聚合1
 * 因为1的数量是固定的,所以是一个固定窗口,看看什么时候里面的0最少,交换的次数就最少
 *
 * @author: Yihu4
 * @create: 2021-11-17 14:38
 */
public class MinimumSwapsToGroupAll1sTogether {
    @Test
    public void test(){
        int[] ints = {1, 0, 1, 0, 1};
        System.out.println(minSwaps(ints));

    }
    public int minSwaps(int[] data) {
        // 窗口大小
        int size = 0;
        for (Integer i : data) {
            size += i;
        }
        if (size == data.length || size == 1) {
            return 0;
        }
        int left = 0;
        int cur0 = 0;
        int res = Integer.MAX_VALUE;
        for (int right = 0; right < data.length; right++) {
            if (data[right] == 0) {
                cur0++;
            }
            if (right - left + 1 > size) {
                if (data[left] == 0) {
                    cur0--;
                }
                left++;
            }
            if (right-left+1==size){
                res = Math.min(res,cur0);
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}
