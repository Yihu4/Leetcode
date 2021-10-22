package leetbook.HashTable.KeyDesign;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * LC 36
 * @author: Yihu4
 * @create: 2021-09-24 20:55
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // 定义数据结构, 每行,每列,每个九宫格都不能重复
        HashMap<Integer, Set<Integer>> row = new HashMap<>();
        HashMap<Integer, Set<Integer>> col = new HashMap<>();
        HashMap<Integer, Set<Integer>> area = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            row.put(i,new HashSet<>());
            col.put(i,new HashSet<>());
            area.put(i,new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 获取每格的字符
                char c = board[i][j];
                if (c == '.'){
                    continue;
                }
                // 字符转 int
                int u = c -'0';
                // 九宫格编号 关键
                int idx = i / 3 * 3 + j / 3;
                if (row.get(i).contains(u)||col.get(j).contains(u)||area.get(idx).contains(u)){
                    return false;
                }
                // 没有重复则在当前的行/列/格集合中加入元素
                row.get(i).add(u);
                col.get(j).add(u);
                area.get(idx).add(u);
            }
        }
        // 校验完之后返回 true
        return true;
    }
}
