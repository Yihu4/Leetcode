package leetbook.queue_stack.queue_BFS;

import java.util.*;

/**
 * LC 752
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 */

public class OpenLock {
    public static void main(String[] args) {
        //测试用例
        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        /*String[] deadends = new String[5];
        deadends[0] = "0201";*/
        String target = "0202";
        //System.out.println(Arrays.toString(Arrays.stream(deadends).toArray()));
        //System.out.println(Arrays.toString(deadends));
        System.out.println(openLock(deadends, target));
    }

    public static int openLock(String[] deadends, String target) {
        // https://blog.csdn.net/kzadmxz/article/details/80394351
        // set无序不重复
        // 放死亡号码,如果过程中遇到了死亡号码,就无法继续
        Set<String> set = new HashSet<>(Arrays.asList(deadends));

        // 从"0000"开始
        String startStr = "0000";
        // 如果死亡列表里面包含了"0000",就直接失败
        if (set.contains(startStr)) {
            return -1;
        }
        // 创建String队列
        Queue<String> queue = new LinkedList<>();
        // 创建记录访问过节点的Set
        Set<String> visited = new HashSet<>();
        queue.add(startStr);
        visited.add(startStr);
        // 树的层数
        int level = 0;
        while (!queue.isEmpty()) {
            // 每层的节点个数
            int size = queue.size();
            // 每层节点几个就循环几次,与在循环结尾size--作用相同
            while (size-- > 0) {
                // 每个节点的值
                String str = queue.poll();

                // 然后对这个节点值的四个数字分别进行加1和减1,相当于创建8个子节点
                for (int i = 0; i < 4; i++) {
                    // 获取第几位的字符
                    char ch = str.charAt(i);
                    // strAdd表示加1,strSub表示减1
                    // ch - '0' + 1是因为ch和'0'都是字符,相减的话会得到与字符内容相等的数字
                    // str.substring(0, i) + str.substring(i + 1);是三个字符,加上要更改的字符刚好是四个字符
                    String strAdd = str.substring(0, i) + (ch == '9' ? 0 : ch - '0' + 1) + str.substring(i + 1);
                    String strSub = str.substring(0, i) + (ch == '0' ? 9 : ch - '0' - 1) + str.substring(i + 1);
                    if (str.equals(target)) {
                        return level;
                    }
                    if (!visited.contains(strAdd) && !set.contains(strAdd)) {
                        queue.add(strAdd);
                        visited.add(strAdd);
                    }
                    if (!visited.contains(strSub) && !set.contains(strSub)) {
                        queue.add(strSub);
                        visited.add(strSub);
                    }

                }

            }
            level++;
        }
        // 如果没找到
        return -1;
    }
}
