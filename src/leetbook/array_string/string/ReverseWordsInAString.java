package leetbook.array_string.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * LC 151
 * @author: mete0ra
 * @create: 2021-08-16 20:48
 */
public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println(reverseWords(" This  is a    test  "));
    }
    public static String reverseWords(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        for (String str:
             wordList) {
            System.out.println(str);

        }
        System.out.println(wordList);
        Collections.reverse(wordList);
        System.out.println(wordList);
        return String.join(" ", wordList);
    }
}
