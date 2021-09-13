package leetbook.LinkedList;


/**
 * LC 707
 * @author: Yihu4
 * @create: 2021-09-04 11:10
 */
public class MyLinkedList {
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    int size;
    Node head;
    /** Initialize your data structure here.
     * 初始化链表
     */
    public MyLinkedList() {
        this.size = 0;
        this.head =null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size || head == null) {
            return -1;
        }
        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node =new Node(val);
        // 节点的 next 指向当前头部
        node.next = this.head;
        // 更新新头部
        this.head = node;
        // 长度++
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (size==0){
            //addAtHead(val);
            // 当前头部 为新节点
            this.head = new Node(val);
            // next 指向 null
            head.next = null;
            size++;
        }else {
            Node temp = this.head;
            // 从头开始往下
            while (temp.next!=null){
                temp = temp.next;
            }
            // 构建尾节点
            Node tail = new Node(val);
            // next 指向 null
            tail.next = null;
            temp.next = tail;
            size++;
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > this.size || index <0) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == this.size) {
            addAtTail(val);
            return;
        }
        // 找到插入节点的上一个节点
        Node temp = this.head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node insertNode = new Node(val);
        insertNode.next = temp.next;
        temp.next = insertNode;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            return;
        }
        if (index == 0) {
            if (size != 1) {
                Node temp = this.head.next;
                this.head =temp;
                size--;
                return;
            }else {
                this.head = null;
                size--;
                return;
            }
        }
        Node temp = this.head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        // 使被删除节点的前一个节点的 next 指向被删除节点的 next
        Node deleteNode = temp.next;
        temp.next = deleteNode.next;
        size--;

    }
}