package leetbook.DynamicPrograming.unclassified;

import java.util.HashSet;

/**
 * @author: Yihu4
 * @create: 2021-11-15 20:31
 */
public class NthTribonacciNumber {
    public int tribonacci(int n) {
        if (n==0){
            return 0;
        }
        if (n==1||n==2){
            return 1;
        }
        int prePrePre=0;
        int prePre = 1;
        int pre = 1;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = prePrePre+prePre+pre;
            prePrePre = prePre;
            prePre = pre;
            pre = res;
        }
        return res;
    }
}
