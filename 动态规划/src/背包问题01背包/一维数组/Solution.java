package 背包问题01背包.一维数组;

public class Solution {
    /*
    一维数组：先物品再背包容量，背包容量倒序遍历
    1.倒序遍历是为了保证物品i只被放入一次！如果一旦正序遍历了，那么一个物品就会被重复加入多次（即只要有空间大于当前物品就可以放进去）！那就变成【完全背包问题】了！
    2.两个嵌套for循环的顺序，代码中是先遍历物品嵌套遍历背包容量，那可不可以先遍历背包容量嵌套遍历物品呢？不可以，如下
    3.如果遍历背包容量放在上一层，那么每个dp[j]就只会放入一个物品，即：背包里只放入了一个物品（要么是当前物品，要么是前面的物品，当前物品会把前面的物品挤出来）。
     */
    public void weightbagproblem(int[] weight, int[] value, int bagsize) {
        int[] dp = new int[bagsize + 1];
        for (int i = 0; i < weight.length; i++) { //物品
            for (int j = bagsize; j >= weight[i]; j--) { //容量倒序
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        System.out.println(dp[bagsize]);
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagsize = 4;
        new Solution().weightbagproblem(weight, value, bagsize);
    }
}
