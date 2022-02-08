package leetbook.math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 89
 * @author: Yihu4
 * @create: 2022-01-08 15:52
 */
public class GrayCode {
    @Test
    public void test(){
        System.out.println(grayCode(4));
    }
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{ add(0); }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }
}
