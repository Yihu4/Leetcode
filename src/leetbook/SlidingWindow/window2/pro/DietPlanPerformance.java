package leetbook.SlidingWindow.window2.pro;

/**
 * LC 1176
 *
 * @author: Yihu4
 * @create: 2021-11-20 17:52
 */
public class DietPlanPerformance {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int left = 0;
        int cur = 0;
        int count = 0;
        for (int right = 0; right < calories.length; right++) {
            cur += calories[right];
            if (right - left + 1 == k) {
                if (cur<lower){
                    count--;
                }
                if (cur>upper){
                    count++;
                }
                cur-=calories[left++];
            }
        }
        return count;
    }
}
