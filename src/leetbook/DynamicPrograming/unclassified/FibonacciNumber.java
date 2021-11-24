package leetbook.DynamicPrograming.unclassified;

/**
 * LC 509
 * @author: Yihu4
 * @create: 2021-11-15 20:27
 */
public class FibonacciNumber {
    public int fib(int n) {
        if (n<2){
            return n;
        }
        int prePre = 0;
        int pre = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = prePre + pre;
            prePre = pre;
            pre = res;
        }
        return res;
    }
}
