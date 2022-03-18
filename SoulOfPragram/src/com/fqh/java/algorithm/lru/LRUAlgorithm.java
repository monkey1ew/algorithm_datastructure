package com.fqh.java.algorithm.lru;

import java.util.HashMap;

/**
 * @author 海盗狗
 * @version 1.0
 * LRU 缓存淘汰算法
 */
public class LRUAlgorithm {

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.get(1);
    }
}

class LRUCache {
    // key ——> Node(key, val);
    private HashMap<Integer, Node> map;
    //Node(k1, v1) <——> Node(k2, v2)
    private DoubleList cache;
    //最大容量
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }
    //将某个key提升为最近使用
    private void makeRecently(int key) {
        Node x = map.get(key);
        //先从链表中删除这个节点
        cache.remove(x);
        //重新插到队尾
        cache.addLast(x);
    }
    //添加最近使用的元素
    private void addRecently(int key, int val) {
        //链表尾部就是最近使用的元素
        Node x = new Node(key, val);
        cache.addLast(x);
        //将node映射到map
        map.put(key, x);
    }
    //删除某一个key
    private void deleteKey(int key) {
        Node x = map.get(key);
        //从链表中删除
        cache.remove(x);
        //从map中删除
        map.remove(key);

    }
    //删除最久未使用的元素
    private void removeLastRecently() {
        // 链表头部就是最久未使用的元素
        Node deleteNode = cache.removeFirst();
        //删除map对应的映射
        int deleteKey = deleteNode.key;
        map.remove(deleteKey);
    }
    //get
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        //将该数据提升为最近使用的
        makeRecently(key);
        return map.get(key).val;
    }

    //put
    public void put(int key, int val) {
        if (map.containsKey(key)) {
            //删除旧的数据
            deleteKey(key);
            //新插入的数据为最近使用的数据
            addRecently(key, val);
            return;
        }
        if (cap == cache.size()) {
            //删除最久未使用的元素
            removeLastRecently();
        }
        //添加未最近使用的元素
        addRecently(key, val);
    }
}

//用Node类型构建双链表
class DoubleList {
    //虚拟头尾节点
    private Node head, tail;
    //链表元素数
    private int size;

    public DoubleList() {
        //初始化双向链表的数据
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    //在链表尾部添加节点x, 时间复杂度 O(1)
    public void addLast(Node x) {
        x.prev = tail.prev; //让x节点的前一个节点指向tail的前一个节点
        x.next = tail;      //让x的下一个节点指向tail
        tail.prev.next = x; //让tail的前一个节点的下一个节点指向x
        tail.prev = x;      //让tail的前一个节点指向x
        size++;
    }

    //删除链表中的 x节点 O(1)
    public void remove(Node x) {
        x.prev.next = x.next; //让x的前一个节点指向x的下一个节点
        x.next.prev = x.prev; //让x的下一个节点的前一个节点指向x的前一个节点
        size--;
    }

    //删除链表中得到第一个节点并返回该节点 O(1)
    public Node removeFirst() {
        if (head == null) {
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }

    //返回链表的长度
    public int size() {
        return size;
    }
}

//双链表的节点类
class Node {
    public int key, val;
    public Node next, prev;
    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}