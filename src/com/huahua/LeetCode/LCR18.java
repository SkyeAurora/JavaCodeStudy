package src.com.huahua.LeetCode;

public class LCR18 {
    public static void main(String[] args) {
        System.out.println(Solution.isPalindrome("A man, a plan, a canal: Panama"));
    }

    class Solution {
        public static boolean isPalindrome(String s) {
            s = s.toLowerCase().replaceAll("[^a-z]", "");

            return true;
        }
    }
}
