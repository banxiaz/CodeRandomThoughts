package 平衡括号字符串的最少插入次数;


public class Solution {
    public int minInsertions(String s) {
        //res记录人为添加的左右括号维护括号平衡
        //need记录对右括号的需求（计入返回值），给了就可以使用，遇到本来就提供了的的就需要从这里面减掉
        int res = 0, need = 0;
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(') {
                need += 2;
                if (need % 2 == 1) { //对右括号需求为奇数（这里间接体现了需要两个连续的右括号）
                    res++; //要添加一个右括号
                    need--; //添加一个右括号后，对右括号的需求减1
                }
            } else {
                need--; //碰到 )，对需求减1
                if (need == -1) { //右括号多了
                    res++; //添加一个左括号
                    need = 1; //添加一个左括号后，对右括号的需求加2
                }
            }
        }
        return res + need;
    }

    public int demo(String s) {
        //设置变量分别用来存储左括号的数量，返回值
        int ans = 0, left = 0, n = s.length();
        char ch;
        for (int i = 0; i < n; i++) {
            ch = s.charAt(i);
            if (ch == '(') {
                left++;
            } else {
                if (i + 1 < n && s.charAt(i + 1) == ')') { //如果有两个连续的右括号，下一次循环直接 +2
                    i++;
                } else { //如果不是，则意味着不管前边有没有左括号，此时都需要补上一个右括号
                    ans++;
                }
                //经过前面的操作，右括号一定已经满足条件了
                if (left > 0) {
                    left--; // 两个右括号匹配一个左括号
                } else {
                    ans++; // 缺少左括号就添加一个左括号
                }
            }
        }
        return ans + left * 2;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().minInsertions("(()))(()))()())))"));
        System.out.println(new Solution().minInsertions(")))))")); //4
        System.out.println(new Solution().demo(")")); //2
    }
}
