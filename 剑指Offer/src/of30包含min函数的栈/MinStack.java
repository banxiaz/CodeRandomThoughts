package of30包含min函数的栈;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stackDate;
    Stack<Integer> stackSup;

    public MinStack() {
        stackDate = new Stack<>();
        stackSup = new Stack<>();
    }

    public void push(int x) {
        stackDate.push(x);

        //栈顶存放当前为止最小值
        if (!stackSup.isEmpty() && x >= stackSup.peek()) {
            stackSup.push(stackSup.peek());
        } else {
            stackSup.push(x);
        }
    }

    public void pop() {
        stackDate.pop();
        stackSup.pop();
    }

    public int top() {
        return stackDate.peek();
    }

    public int min() {
        return stackSup.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }
}
