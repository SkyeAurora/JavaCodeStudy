package src.com.huahua.LeetCode;

public class LCR2 {
    public static void main(String[] args) {
        System.out.println(Solution.addBinary("1","1"));
    }
    class Solution {
        public static String addBinary(String a, String b) {
            String ans = new String();
            int m = a.length(), n = b.length();
            int i = m - 1, j = n - 1;
            int CF = 0;
            while (i >= 0 || j >= 0) {
                int t = 0;
                if (i >= 0) {
                    t += a.charAt(i) - '0';
                    i--;
                }
                if (j >= 0) {
                    t += b.charAt(j) - '0';
                    j--;
                }
                t += CF;
                CF = t / 2;
                t = t % 2;
                ans += t;
            }
            return CF == 0 ? ans : ans + CF;
        }
    }
}