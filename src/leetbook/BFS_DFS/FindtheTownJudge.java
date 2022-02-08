package leetbook.BFS_DFS;

/**
 * LC 997
 * 小镇法官不会信任任何人。
 * 每个人（除了小镇法官）都信任这位小镇法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 * @author: Yihu4
 * @create: 2021-12-19 12:48
 */
public class FindtheTownJudge {
    public int findJudge(int n, int[][] trust) {
        // 入度
        int[] in = new int[n + 1];
        // 出度
        int[] out = new int[n + 1];
        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];
            in[b]++;
            out[a]++;
        }
        for (int i = 1; i <= n; i++) {
            // 如果被信任的数量是人数-1,并且不信任任何人
            if (in[i] == n - 1 && out[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
