package 中缀表达式求值;

import java.util.Stack;

// https://blog.csdn.net/weixin_42034217/article/details/84680437
// 1. 定义两个栈，一个存放数字，一个存放操作符号
// 2. 如果当前是数字，则直接入数字栈
// 3. 如果当前是操作符号
//   1. 如果栈为空，直接入栈
//   2. 如果当前是'('，优先级最高，直接入栈
//   3. 如果当前的栈顶是'('，直接入栈
//   4. 如果当前的优先级比栈顶的大或者相等，直接入栈
//   5. 如果当前的优先级小于栈顶，从数字栈取出两个元素，从符号栈取出一个元素，计算值后放入数字栈
//   6. 重复步骤5，直到遇到3或者4，将当前操作符入栈
//   7. 如果当前的是')'，从数字栈取出两个元素，从符号栈取出一个元素，计算值后放入数字栈
//   8. 重复步骤7的操作直到遇到'('，将')'出栈
public class Solution1 {
    public static void main(String[] args) {
        // 为简单起见，只支持 0-9的数字
        String expression = "(1-2)+(3-1)";
        int res = calcExpression(expression);
        System.out.println(res);
    }

    private static int calcExpression(String expression) {
        char[] exp = expression.toCharArray();
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opeStack = new Stack<>();
        for (char c : exp) {
            if (c == '+' || c == '-') {
                if (!opeStack.isEmpty()) {
                    while (!opeStack.isEmpty() && (opeStack.peek() == '+' || opeStack.peek() == '-'
                            || opeStack.peek() == '*' || opeStack.peek() == '/')) {
                        int a = numStack.pop();
                        int b = numStack.pop();
                        int opera = opeStack.pop();
                        numStack.push(cal(b, a, opera));
                    }
                }
                opeStack.push(c);
            } else if (c == '*' || c == '/') {
                if (!opeStack.isEmpty()) {
                    while (!opeStack.isEmpty() && (opeStack.peek() == '*' || opeStack.peek() == '/')) {
                        int a = numStack.pop();
                        int b = numStack.pop();
                        int opera = opeStack.pop();
                        numStack.push(cal(b, a, opera));
                    }
                }
                opeStack.push(c);
            } else if (c == '(') {
                opeStack.push(c);
            } else if (c == ')') {
                while (opeStack.peek() != '(') {
                    int a = numStack.pop();
                    int b = numStack.pop();
                    int opera = opeStack.pop();
                    numStack.push(cal(b, a, opera));
                }
                opeStack.pop(); // 弹出'('
            } else {
                numStack.push(c - '0');
            }
        }

        while (!opeStack.isEmpty()) {
            int a = numStack.pop();
            int b = numStack.pop();
            int opera = opeStack.pop();
            numStack.push(cal(b, a, opera));
        }
        return numStack.pop();
    }

    private static int cal(int a, int b, int opera) {
        switch (opera) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                return 0;
        }
    }

}
