package src.com.huahua.LeetCode;

public class LC125 {
    public static void main(String[] args) {
        System.out.println(Solution.isPalindrome("A man, a plan, a canal: Panama"));
    }

    class Solution {
        public static boolean isPalindrome(String s) {
            s.trim();
            String str = s.toLowerCase().replaceAll("[^a-z]", "");
            if (str.length() == 0) {
                return true;
            }
            int l = 0, r = str.length() - 1;
            while (l < r) {
                if (str.charAt(l) != str.charAt(r)) {
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }
    }
}

