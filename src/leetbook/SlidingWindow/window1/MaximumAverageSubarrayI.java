package leetbook.SlidingWindow.window1;

import org.junit.Test;

/**
 * LC 643
 *
 * @author: Yihu4
 * @create: 2021-11-06 16:09
 */
public class MaximumAverageSubarrayI {
    @Test
    public void test(){
        int[] ints = {1, 12, -5, -6, 50, 3};
        findMaxAverage(ints,4);
    }
    public double findMaxAverage(int[] nums, int k) {
        int l = 0;
        int count = k;
        double sum = 0;
        double avg = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (count != 0) {
                sum += nums[i];
                count--;
            }
            if (count == 0) {
                avg = Math.max(avg, sum / k);
                sum -= nums[i - k+1];
                count++;
            }
        }
        return avg;
    }
}
