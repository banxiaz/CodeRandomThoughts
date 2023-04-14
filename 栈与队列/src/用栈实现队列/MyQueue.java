package 用栈实现队列;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        dumpStackIn();
        return stackOut.pop();
    }

    public int peek() {
        dumpStackIn();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.empty() && stackOut.empty();
    }

    // 如果stackOut为空，那么将stackIn中的元素全部放到stackOut中
    public void dumpStackIn() {
        if (!stackOut.empty()) {
            return;
        }
        while (!stackIn.empty()) {
            stackOut.push(stackIn.pop());
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.peek());
        while (!myQueue.empty()) {
            System.out.println(myQueue.pop());
        }
    }
}
