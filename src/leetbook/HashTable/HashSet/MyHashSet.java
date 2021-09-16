package leetbook.HashTable.HashSet;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * LC 705
 * https://leetcode-cn.com/problems/design-hashset/solution/yi-ti-san-jie-jian-dan-shu-zu-lian-biao-nj3dg/
 * 尽量用素数,效率更高
 * n % 素数
 * @author: Yihu4
 * @create: 2021-09-13 20:58
 */
//LC 正解
public class MyHashSet {
    // 素数效率高
    private static final int BASE = 769;
    private LinkedList[] data;

    /** Initialize your data structure here. */
    public MyHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; ++i) {
            // 数组每一个下标都跟一个链表
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        // 先找数组下标
        int h = hash(key);
        // 再找链表
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return;
            }
        }
        // 尾插
        data[h].offerLast(key);
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                data[h].remove(element);
                return;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return true;
            }
        }
        return false;
    }

    private static int hash(int key) {
        return key % BASE;
    }
}

// 三叶链表
class MyHashSetSyLinkedList {
    // 由于使用的是「链表」，这个值可以取得很小
    Node[] nodes = new Node[10009];

    public void add(int key) {
        // 根据 key 获取哈希桶的位置
        int idx = getIndex(key);
        // 判断链表中是否已经存在
        Node loc = nodes[idx];
        Node tmp = loc;
        if (loc != null) {
            // 如果没有 prev 的话就是 while(tmp.next !=null)
            // 这样的如果 add 会漏掉尾节点,可能会有重复值
            Node prev = null;
            while (tmp != null) {
                if (tmp.key == key) {
                    return;
                }
                prev = tmp;
                // 往下直到为空
                tmp = tmp.next;
            }
            // 为空的前一个,即尾
            tmp = prev;
        }
        Node node = new Node(key);

        // 头插法
        // node.next = loc;
        // nodes[idx] = node;

        // 尾插法
        if (tmp != null) {
            // 尾部的下一个新增
            tmp.next = node;
        } else {
            nodes[idx] = node;
        }
    }

    public void remove(int key) {
        int idx = getIndex(key);
        Node loc = nodes[idx];
        if (loc != null) {
            Node prev = null;
            while (loc != null) {
                if (loc.key == key) {
                    if (prev != null) {
                        prev.next = loc.next;
                    } else {
                        nodes[idx] = loc.next;
                    }
                    return;
                }
                prev = loc;
                loc = loc.next;
            }
        }
    }

    public boolean contains(int key) {
        int idx = getIndex(key);
        Node loc = nodes[idx];
        if (loc != null) {
            while (loc != null) {
                if (loc.key == key) {
                    return true;
                }
                loc = loc.next;
            }
        }
        return false;
    }

    static class Node {
        private int key;
        private Node next;
        private Node(int key) {
            this.key = key;
        }
    }

    int getIndex(int key) {
        // 因为 nodes 的长度只有 10009，对应的十进制的 10011100011001（总长度为 32 位，其余高位都是 0）
        // 为了让 key 对应的 hash 高位也参与运算，这里对 hashCode 进行右移异或
        // 使得 hashCode 的高位随机性和低位随机性都能体现在低 16 位中
        int hash = Integer.hashCode(key);
        hash ^= (hash >>> 16);
        return hash % nodes.length;
    }
}

