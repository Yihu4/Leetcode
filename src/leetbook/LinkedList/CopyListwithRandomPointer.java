package leetbook.LinkedList;

import java.util.HashMap;

/**
 * LC 138
 * @author: Yihu4
 * @create: 2021-09-11 10:22
 */
public class CopyListwithRandomPointer {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node p = head;
        Node q;
        while (p != null) {
            q = new Node(p.val);
            map.put(p, q);
            p = p.next;
        }
        p = head;
        q = map.get(p);
        while (p != null) {
            q.next = map.get(p.next);
            q.random = map.get(p.random);
            q = q.next;
            p = p.next;
        }
        return map.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
