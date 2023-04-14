package 为运算表达式设计优先级;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    //分而治之
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new LinkedList<>();
        int len = expression.length();
        int start = 0;
        for (start = 0; start < len; start++) {
            if (Character.isDigit(expression.charAt(start))) {
                continue;
            } else {
                break;
            }
        }
        //如果只是不带符号的数字，直接返回
        if (start == len) {
            res.add(Integer.parseInt(expression));
            return res;
        }

        for (int i = 0; i < len; i++) {
            char c = expression.charAt(i);
            //分
            if (c == '-' || c == '*' || c == '+') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                //治
                for (int a : left) {
                    for (int b : right) {
                        if (c == '+') {
                            res.add(a + b);
                        } else if (c == '-') {
                            res.add(a - b);
                        } else if (c == '*') {
                            res.add(a * b);
                        }
                    }
                }
            }
        }
        return res;
    }
}
