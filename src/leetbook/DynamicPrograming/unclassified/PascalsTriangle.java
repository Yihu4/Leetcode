package leetbook.DynamicPrograming.unclassified;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 118
 *
 * @author: Yihu4
 * @create: 2021-11-18 15:42
 */
public class PascalsTriangle {
    @Test
    public void test() {
        System.out.println(generate(5));

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> preRow = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            // 每一行
            ArrayList<Integer> curRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i ) {
                    curRow.add(1);
                } else {
                    curRow.add(preRow.get(j - 1) + preRow.get(j));
                }

            }
            lists.add(curRow);
            preRow = curRow;
        }
        return lists;
    }
}
