package leetbook.queue_stack.stack_dfs;

import java.util.Arrays;
import java.util.Stack;
/**
 * 请根据每日 气温 列表 temperatures
 * 请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 */

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperaturesStack(temperatures)));
    }

    /**
     * 暴力算法
     */
    public int[] dailyTemperaturesBaoLi(int[] temperatures) {
        int length = temperatures.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                //如果后面的比前面的大,则在结果数组中填入两天的差值
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    public static int[] dailyTemperaturesStack(int[] temperatures) {
        //创建栈,栈中存的是数组的下标
        Stack<Integer> stack = new Stack<>();
        //数组创造时初值全为0
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            //每次都要检查是否需要出栈,对比的是气温数组中的值
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                //因为最后如果有更高气温的都会出栈
                int idx = stack.pop();
                //当前遍历位置减去出栈位置即天数
                res[idx] = i - idx;
            }
            //每次都要入栈
            stack.push(i);
        }
        return res;
    }
}
