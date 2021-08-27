package leetbook.array_string.arrayrelati;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 119
 *
 * @author: mete0ra
 * @create: 2021-08-26 19:34
 */
public class PascalsTriangle2 {
    public static void main(String[] args) {
        System.out.println(generate1(5));
    }

    // 滚动数组
    public static List<Integer> generate2(int numRows) {
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            // 每一层结束 pre 变成 cur
            pre = cur;
        }
        return pre;
    }

    // 一维
    public static List<Integer> generate1(int numRows) {
        List<Integer> cur = new ArrayList<>();
        // 第一个元素以后不动
        cur.add(1);
        for (int i = 0; i <= numRows; i++) {
            if (i != 0) {
                cur.add(0);
            }
            for (int j = i; j > 0; j--) {
                cur.set(j, cur.get(j - 1) + cur.get(j));
            }
        }
        return cur;
    }
}


