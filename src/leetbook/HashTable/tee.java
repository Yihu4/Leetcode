package leetbook.HashTable;

import java.util.LinkedList;

/**
 * @author: Yihu4
 * @create: 2021-09-14 15:41
 */
public class tee {
    static Node1[] arr = new Node1[1];

    public static void main(String[] args) {
        add(1);
        add(2);
        add(2);
        System.out.println(contains(1));
        System.out.println(contains(3));


    }

    public static void add(int key) {
        // 根据 key 获取哈希桶的位置
        // 判断链表中是否已经存在
        Node1 loc = arr[0];
        Node1 tmp = loc;
        if (loc != null) {
            while (tmp.next != null) {
                if (tmp.key == key) {
                    return;
                }
                // 往下直到为空
                tmp = tmp.next;
            }
            // 为空的前一个,即尾
        }
        Node1 node = new Node1(key);

        // 头插法
        // node.next = loc;
        // nodes[idx] = node;

        // 尾插法
        if (tmp != null) {
            // 尾部的下一个新增
            tmp.next = node;
        } else {
            arr[0] = node;
        }
    }
    public static boolean contains(int key) {

        Node1 loc = arr[0];
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
    public static void remove(int key) {
        Node1 loc = arr[0];
        if (loc != null) {
            Node1 prev = null;
            while (loc != null) {
                if (loc.key == key) {
                    if (prev != null) {
                        prev.next = loc.next;
                    } else {
                        arr[0] = loc.next;
                    }
                    return;
                }
                prev = loc;
                loc = loc.next;
            }
        }
    }

}

class Node1 {
    public int key;
    public Node1 next;

    public Node1(int key) {
        this.key = key;
    }
}
