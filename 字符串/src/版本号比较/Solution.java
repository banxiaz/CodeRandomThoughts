package 版本号比较;

import java.util.Arrays;

public class Solution {
    public static int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int len = Math.max(str1.length, str2.length);

        for (int i = 0; i < len; i++) {
            int num1 = (i < str1.length ? Integer.parseInt(str1[i]) : 0);
            int num2 = (i < str2.length ? Integer.parseInt(str2[i]) : 0);
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String version1 = "1.0";
        String version2 = "1.0.0.1";
        System.out.println(compareVersion(version1, version2));

        String[] strS = {"1.34", "1.01", "1.001", "1.02", "0.1.1.2", "0.1.1.1"};
        Arrays.sort(strS, Solution::compareVersion);
        System.out.println(Arrays.toString(strS));
    }
}
