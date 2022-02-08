package leetbook.DynamicPrograming.linear;

import org.junit.Test;

/**
 * LC 1055
 * target最少能用几个source的子序列组成subsequence
 * @author: Yihu4
 * @create: 2021-12-06 15:27
 */
public class ShortestWaytoFormString {
    @Test
    public void test(){
        System.out.println(shortestWay("abc", "abbcc"));
    }
    // 双指针
    public int shortestWay(String source, String target) {
        int m=source.length();
        int n=target.length();
        int i=0;
        int j=0;
        int result=0;
        //target从左到右依次遍历，并循环遍历source
        while(j<n){
            i=0;
            int curJ=j;
            //对source遍历
            while(i<m && j<n){
                if(source.charAt(i)==target.charAt(j)){
                    i++;
                    j++;
                }else{
                    i++;
                }
            }
            //如果j>curj,说明当前字段区间可以被source覆盖
            if(j > curJ){
                result++;
            }else{
                return -1;
            }
        }
        return result;
    }
}
