package leetbook.array.CollisionPointer;

import org.junit.Test;

/**
 * LC 11
 *
 * @author: Yihu4
 * @create: 2021-11-06 10:40
 */
public class ContainerWithMostWater {
    @Test
    public void test() {
        int[] ints = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    }

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            // 目前容量
            int cur = Math.min(height[l], height[r]) * (r - l);
            max = Math.max(max, cur);
            // 解析:如果固定小的那根柱子,移动大的那一边
            // 底减小,但是高度不变,容量只会减小
            // 所以可以排除小的那根柱子
            if (height[l] > height[r]) {
                r--;
            }else {
                l++;
            }
        }
        return max;
    }
}
