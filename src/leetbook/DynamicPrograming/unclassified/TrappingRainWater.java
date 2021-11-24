package leetbook.DynamicPrograming.unclassified;

import org.junit.Test;

import java.util.Stack;

/**
 * LC 42
 *
 * @author: Yihu4
 * @create: 2021-11-23 20:53
 */
public class TrappingRainWater {
    @Test
    public void test() {
        int[] ints = {5, 4, 3, 2, 1, 2, 3, 4, 5};
        System.out.println(trapDPOp(ints));
    }

    public int trap(int[] height) {
        // 两个dp数组分别记录下标柱子之前的最高和之后的最高
        int[] preMax = new int[height.length];
        int[] afterMax = new int[height.length];
        // 可省略
        preMax[0] = 0;
        for (int i = 1; i < preMax.length; i++) {
            preMax[i] = Math.max(preMax[i - 1], height[i - 1]);
        }
        // 可省略
        afterMax[height.length - 1] = 0;
        for (int i = height.length - 2; i > 0; i--) {
            afterMax[i] = Math.max(afterMax[i + 1], height[i + 1]);
        }
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            if (height[i] < Math.min(preMax[i], afterMax[i])) {
                sum += Math.min(preMax[i], afterMax[i]) - height[i];
            }
        }
        return sum;
    }

    // dp优化 (双指针)
    public int trapDPOp(int[] height) {
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2; // 加右指针进去
        while (left<=right){
            //从左到右更
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if (min > height[left]) {
                    sum  = sum + (min - height[left]);
                }
                left++;
                //从右到左更
            } else {
                // 因为左墙大于等于右墙,所以左右最低点为右边最高的墙
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    // 高减低为该位置的储水量
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }

    public int trap6(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                // 底的高度
                int h = height[stack.peek()]; //取出要出栈的元素
                stack.pop(); //出栈
                if (stack.empty()) { // 栈空就出去
                    break;
                }
                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
                // 两墙之中低的那一堵墙
                int min = Math.min(height[stack.peek()], height[current]);
                // 计算current柱子和栈顶柱子之间矩形的面积
                sum = sum + distance * (min - h);
            }
            stack.push(current); //当前指向的墙入栈
            current++; //指针后移
        }
        return sum;
    }
}