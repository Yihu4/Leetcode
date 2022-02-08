package leetbook.math;

/**
 * LC 2029
 * @author: Yihu4
 * @create: 2022-01-20 17:50
 */
public class StoneGameXI {
    public boolean stoneGameIX(int[] stones) {
        int[] cnts = new int[3];
        for (int i : stones) {
            cnts[i % 3]++;
        }
        return cnts[0] % 2 == 0 ? !(cnts[1] == 0 || cnts[2] == 0) : Math.abs(cnts[1] - cnts[2]) > 2;
    }
}
