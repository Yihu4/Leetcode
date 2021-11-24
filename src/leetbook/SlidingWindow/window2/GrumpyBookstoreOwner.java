package leetbook.SlidingWindow.window2;

import org.junit.Test;

/**
 * LC 1052
 * Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
 * Output: 16
 * @author: Yihu4
 * @create: 2021-11-13 14:52
 */
public class GrumpyBookstoreOwner {
    @Test
    public void test(){
    }
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        // 正常情况下的客人数量
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            sum += customers[i] * (1-grumpy[i]);
        }
        int left = 0;
        // 挽回的客人数量
        int save = 0;
        int maxSave = 0;
        for (int right = 0; right < customers.length; right++) {
            if (grumpy[right]==1){
                save+=customers[right];
            }
            if (right-left+1>minutes){
                if (grumpy[left]==1){
                    save-=customers[left];
                }
                left++;
            }
            maxSave = Math.max(maxSave,save);
        }
        return sum+maxSave;
    }
}
