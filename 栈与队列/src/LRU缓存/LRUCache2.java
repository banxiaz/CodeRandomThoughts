package LRU缓存;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


// 靠近头部的键值对是最近使用的，而靠近尾部的键值对是最久未使用的
// 哈希表即为普通的哈希映射（HashMap），通过缓存数据的键映射到其在双向链表中的位置
public class LRUCache2 {
    private Map<Integer, Node> map;
    private List<Node> cache; //
    private int cap;

    public LRUCache2(int cap) {
        this.map = new HashMap<>();
        this.cache = new LinkedList<>();
        this.cap = cap;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        cache.remove(node);
        cache.add(0, node);
        return node.val;

    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            cache.remove(node);
            node.val = value;
            cache.add(0, node);
            return;
        }

        if (cap == cache.size()) {
            Node node = cache.get(cache.size() - 1);
            cache.remove(node);
            map.remove(node.key);
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        cache.add(0, newNode);
    }
}
