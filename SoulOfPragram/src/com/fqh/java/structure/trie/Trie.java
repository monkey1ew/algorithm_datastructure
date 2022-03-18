package com.fqh.java.structure.trie;

/**
 * @author 海盗狗
 * @version 1.0
 * 字典树
 */
public class Trie {

    public static void main(String[] args) {

    }
}

class TrieMap<V> {

    //ASCII 码个数
    private static final int R = 256;
    // 当前存在map 中的键值对个数
    private int size = 0;

    private static class TrieNode<V> {
        V val = null;
        TrieNode<V>[] children = new TrieNode[R];
    }

//    Trie 树的根节点
    private TrieNode<V> root = null;

    public int size() {
        return size;
    }

//    从node节点 开始搜索key, 如果存在返回对应节点
    private TrieNode<V> getNode(TrieNode<V> node, String key) {
        TrieNode<V> p = node;
//        从node 开始搜索 key
        for (int i = 0; i < key.length(); i++) {
            if (p == null) {
                // 无法向下搜索
                return null;
            }
//            向下搜索
            char c = key.charAt(i);
            p = p.children[c];
        }
        return p;
    }

//    搜索key 对应的值, 不存在返回null
    public V get(String key) {
//        从root 开始搜索key
        TrieNode<V> x = getNode(root, key);
        if (x == null || x.val == null) {
//            x为null || x的val字段为Null, 说明key没有对应值
            return null;
        }
        return x.val;
    }

//    判断key 是否存在Map中
    public boolean containsKey(String key) {
        return get(key) != null;
    }

//    判断是否存在前缀为prefix 的键
    public boolean hasKeyWithPrefix(String prefix) {
//        只要能找到 prefix 对应的节点, 就是存在前缀
        return getNode(root, prefix) != null;
    }

//    在所有键中寻找 query 的最短前缀
    public String shortestPrefix(String query) {
        TrieNode<V> p = root;
//        从节点node 开啊是搜索key
        for (int i = 0; i < query.length(); i++) {
            if (p == null) {
//                无法向下搜索
                return null;
            }
            if (p.val != null) {
//                找到一个键是 query的 前缀
                return query.substring(0, i);
            }
//            向下搜索
            char c = query.charAt(i);
            p = p.children[c];
        }
        if (p != null && p.val != null) {
//            如果query本身就是一个键
            return query;
        }
        return "";
    }
}
