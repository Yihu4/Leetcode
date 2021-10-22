package leetbook.HashTable.summary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * LC 380
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 *
 *让我们一个个进行思考，虽然哈希表提供常数时间的插入和删除，但是实现 getRandom 时会出现问题。
 * getRandom 的思想是选择一个随机索引，然后使用该索引返回一个元素。而哈希表中没有索引，因此要获得真正的随机值，则要将哈希表中的键转换为列表，这需要线性时间。解决的方法是用一个列表存储值，并在该列表中实现常数时间的 getRandom。
 *
 * 列表有索引可以实现常数时间的 insert 和 getRandom，则接下来的问题是如何实现常数时间的 remove。
 *
 * 删除任意索引元素需要线性时间，这里的解决方案是总是删除最后一个元素。
 *
 * 将要删除元素和最后一个元素交换。
 * 将最后一个元素删除。
 * 为此，必须在常数时间获取到要删除元素的索引，因此需要一个哈希表来存储值到索引的映射。
 *
 * 综上所述，我们使用以下数据结构：
 *
 * 动态数组存储元素值
 * 哈希表存储存储值到索引的映射。
 * @author: Yihu4
 * @create: 2021-10-13 20:39
 */
class RandomizedSet {
    HashMap<Integer, Integer> map = null;
    List<Integer> list = null;
    private static Random random = new Random();

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        Integer index = map.get(val);
        //bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
        map.put(list.get(list.size() - 1), index);
        map.put(val, list.get(list.size() - 1));

        list.set(index, list.get(list.size() - 1));
        list.set(list.size() - 1, val);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

}
