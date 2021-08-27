package leetbook.array_string.arrayrelati;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 118
 * @author: mete0ra
 * @create: 2021-08-26 19:14
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5).toString());

    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            // j <= i 是因为 i 从零开始
            for (int j = 0; j <= i; j++) {
                // 首或者尾为 0
                if (j == 0 || j == i) {
                    row.add(1);
                }else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }
}
