package 设计跳表;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class SkipListNode {
    int val;
    SkipListNode[] forward;

    public SkipListNode(int val, int maxLevel) {
        this.val = val;
        this.forward = new SkipListNode[maxLevel];
    }
}

public class SkipList {
    static final int MAX_LEVEL = 8;
    static final double P_FACTOR = 0.5d;
    private final SkipListNode head;
    private int level; //记录实际的记录了数据的所有层中最大层数，初始为0
    private final Random random;

    public SkipList() {
        this.head = new SkipListNode(-1, MAX_LEVEL);
        this.level = 0;
        this.random = new Random();
    }

    public void add(int num) {
        SkipListNode[] update = new SkipListNode[MAX_LEVEL]; // 用来记录待插入节点的每一层的前驱节点
        Arrays.fill(update, head);
        SkipListNode curr = this.head;
        for (int i = level - 1; i >= 0; i--) {
            /* 对第 i 层的状态进行更新，将当前元素的 forward 指向新的节点 */
            while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }

        int lv = getRandomLevel();
        level = Math.max(level, lv);
        SkipListNode newNode = new SkipListNode(num, lv);
        for (int i = 0; i < lv; i++) {
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode; // 只更新小于等于他的那些层
        }
    }

    public boolean search(int target) {
        SkipListNode curr = this.head;
        for (int i = level - 1; i >= 0; i--) {
            /* 找到第 i 层小于且最接近 target 的元素*/
            while (curr.forward[i] != null && curr.forward[i].val < target) {
                curr = curr.forward[i];
            }
        }
        curr = curr.forward[0];
        if (curr != null && curr.val == target) {
            return true;
        }
        return false;
    }

    public boolean erase(int num) {
        SkipListNode[] update = new SkipListNode[MAX_LEVEL];
        SkipListNode curr = this.head;
        for (int i = level - 1; i >= 0; i--) {
            /* 找到第 i 层小于且最接近 num 的元素*/
            while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }
        curr = curr.forward[0];
        /* 如果值不存在则返回 false */
        if (curr == null || curr.val != num) {
            return false;
        }

        for (int i = 0; i < level; i++) {
            if (update[i].forward[i] != curr) {
                break;
            }
            /* 对第 i 层的状态进行更新，将 forward 指向被删除节点的下一跳 */
            update[i].forward[i] = curr.forward[i];
        }

        /* 更新当前的 level */
        while (level > 1 && head.forward[level - 1] == null) {
            level--;
        }
        return true;
    }

    public void print() {
        Map<Integer, Integer> map = new HashMap<>();
        int startIndex = 0;
        SkipListNode temp = head;
        while (temp != null) {
            map.put(temp.val, startIndex++);
            temp = temp.forward[0];
        }

        for (int i = MAX_LEVEL - 1; i >= 0; i--) {
            System.out.printf("[%d] ", i);
            SkipListNode cur = this.head;
            while (cur != null) {
                int index = 0;
                while (cur != null) {
                    for (int j = index; j < map.get(cur.val); j++) {
                        System.out.print("\t");
                    }
                    index = map.get(cur.val) + 1;
                    System.out.printf("%d\t", cur.val);
                    cur = cur.forward[i];
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void print1() {
        for (int i = MAX_LEVEL - 1; i >= 0; i--) {
            System.out.printf("[%d] ", i);
            SkipListNode cur = this.head;
            while (cur != null) {
                System.out.printf("%d\t", cur.val);
                cur = cur.forward[i];
            }
            System.out.println();
        }
        System.out.println();
    }

    public void print2() {
        Map<Integer, Integer> map = new HashMap<>();
        int startIndex = 0;
        for (int i = 0; i < MAX_LEVEL; i++) {
            System.out.printf("[%d] ", i);
            SkipListNode cur = this.head;
            if (i == 0) {
                while (cur != null) {
                    map.put(cur.val, startIndex++);
                    System.out.printf("%d\t", cur.val);
                    cur = cur.forward[i];
                }
            } else {
                int index = 0;
                while (cur != null) {
                    for (int j = index; j < map.get(cur.val); j++) {
                        System.out.print("\t");
                    }
                    index = map.get(cur.val) + 1;
                    System.out.printf("%d\t", cur.val);
                    cur = cur.forward[i];
                }
            }
            System.out.println();
        }
        System.out.println();
    }


    private int getRandomLevel() {
        int lv = 1;
        while (random.nextDouble() < P_FACTOR && lv < MAX_LEVEL) {
            lv++;
        }
        return lv;
    }
}

class Test {
    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.print();

        for (int i = 0; i < 200; i++) {
            skipList.add(i);
        }
        skipList.print();


        for (int i = 0; i < 200; i++) {
            skipList.search(i);
        }
        for (int i = 0; i < 200; i++) {
            skipList.erase(i);
        }
        skipList.print();
    }
}