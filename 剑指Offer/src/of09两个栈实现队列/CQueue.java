package of09两个栈实现队列;

import java.util.Stack;

public class CQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public CQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void appendTail(int value) {
        stackIn.push(value);
    }

    public int deleteHead() {
        if (stackIn.empty() && stackOut.empty()) {
            return -1;
        }
        if (!stackOut.empty()) {
            return stackOut.pop();
        }
        while (!stackIn.empty()) {
            stackOut.push(stackIn.pop());
        }
        return stackOut.pop();
    }
}
