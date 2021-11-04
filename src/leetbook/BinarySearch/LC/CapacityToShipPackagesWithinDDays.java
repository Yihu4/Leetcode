package leetbook.BinarySearch.LC;

import org.junit.Test;

/**
 * LC 1101
 *
 * @author: Yihu4
 * @create: 2021-11-03 17:50
 */
public class CapacityToShipPackagesWithinDDays {
    @Test
    public void test(){
        int[] ints = {3,2,2,4,1,4};
        System.out.println(check(ints, 6));
    }

    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        // 最小运力为一个包裹的最大值
        for (int i : weights) {
            max = Math.max(max, i);
        }
        // 最大运力为所以包裹的总和(一天运完)
        int sum = 0;
        for (int i : weights) {
            sum += i;
        }
        while (max< sum){
            int mid = max+ (sum -max)/2;
            if (check(weights,mid)>days){
                // 如果花费的天数多,则加快速度
                max=mid+1;
            }else {
                sum=mid;
            }
        }
        return sum;
    }

    private int check(int[] weights, int capacity) {
        int count = 0;
        int dayCapacity = capacity;
        for (int i = 0; i < weights.length; i++) {
            capacity -= weights[i];
            if (i == weights.length - 1) {
                count++;
                capacity= dayCapacity;
                continue;
            }
            if (capacity - weights[i + 1] < 0) {
                count++;
                capacity= dayCapacity;
            }
        }
        return count;
    }
}
