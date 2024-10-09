package src.com.huahua.LeetCode;

public class LCR19 {
    
    public static void main(String[] args) {
        System.out.println(Solution.validPalindrome("abc"));
    }

    class Solution {
        public static boolean validPalindrome(String s) {
            int l = 0, r = s.length() - 1;
            while (l < r && s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }
            if (l > r) {
                return true;
            }
            if (check(s, l + 1, r) || check(s, l, r - 1)) {
                return true;
            }
            return false;
        }
    
        private static boolean check(String s, int l, int r) {
            while (l < r) {
                if (s.charAt(l++) == s.charAt(r--)) {
                    return false;
                }
            }
            return true;
        }
    }
}
