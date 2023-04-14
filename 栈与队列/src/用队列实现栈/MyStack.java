package 用队列实现栈;

import java.util.Deque;
import java.util.LinkedList;

public class MyStack {
    // Deque 接口继承了 Queue 接口
    // 所以 Queue 中的 add、poll、peek等效于 Deque 中的 addLast、pollFirst、peekFirst
    Deque<Integer> que1;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        que1 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        que1.addLast(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int size = que1.size();
        size--;
        while (size-- > 0) {
            que1.addLast(que1.peekFirst());
            que1.pollFirst();
        }

        int res = que1.pollFirst();
        return res;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return que1.peekLast();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return que1.isEmpty();
    }
}
