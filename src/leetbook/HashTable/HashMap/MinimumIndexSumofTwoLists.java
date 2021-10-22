package leetbook.HashTable.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * LC 599
 * @author: Yihu4
 * @create: 2021-09-23 19:42
 */
public class MinimumIndexSumofTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        List<String> res =new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i],i);
        }
        for (int i = 0; i < list2.length; i++) {
            Integer num= map.get(list2[i]);
            if (num!=null){
                int newNum = num + i;
                if (newNum<=min){
                    if (newNum<min){
                        res.clear();
                    }
                    min = newNum;
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[]{});
    }
}
