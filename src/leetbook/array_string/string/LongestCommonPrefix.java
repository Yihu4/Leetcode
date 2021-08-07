package leetbook.array_string.string;

import java.util.Arrays;

/**
 * LC 14
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串""。
 * <p>
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * <p>
 * <p>
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * @author: mete0ra
 * @create: 2021-08-05 10:34
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"aaa", "aa", "aaa"};
        System.out.println((longestCommonPrefix(strs)));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            // res的长度在变, 不能用strs[0]的长度, 因为如果循环下去strs[0]的长度大于res的长度会出现outofindex
            for (; j < res.length() && j < strs[i].length(); j++) {
                // 一次循环就能得出公共前缀, 如果接下来的前缀对不上了则会用substring(0, j)语句删减
                // 只要有一个字符不同, 就break
                if (strs[i].charAt(j) != res.charAt(j)) {
                    break;
                }
            }
            res = res.substring(0, j);
            // 如果有任何一个为空, 直接返回
            if ("".equals(res)) {
                return res;
            }
        }
        return res;
    }

}
