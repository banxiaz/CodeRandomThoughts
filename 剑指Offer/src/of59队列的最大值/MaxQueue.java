package of59队列的最大值;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//实现单调队列，队头保存最大值
class MyQueue {
    Deque<Integer> deque = new LinkedList<>();

    //添加元素
    void add(int val) {
        while (!deque.isEmpty() && val > deque.peekLast()) {
            deque.pollLast();
        }
        deque.offerLast(val);
    }

    //弹出元素
    void poll(int val) {
        if (!deque.isEmpty() && deque.peekFirst() == val) {
            deque.pollFirst();
        }
    }

    int peek() {
        return deque.peekFirst();
    }
}

public class MaxQueue {
    MyQueue myQueue;
    Queue<Integer> queue;

    public MaxQueue() {
        myQueue = new MyQueue();
        queue = new LinkedList<>();
    }

    public void push_back(int value) {
        queue.offer(value);
        myQueue.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        } else {
            int res = queue.poll();
            myQueue.poll(res);
            return res;
        }
    }

    public int max_value() {
        if (queue.isEmpty()) {
            return -1;
        } else {
            return myQueue.peek();
        }
    }
}


