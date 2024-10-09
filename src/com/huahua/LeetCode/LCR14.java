package src.com.huahua.LeetCode;

import java.util.Arrays;

public class LCR14 {

    public static void main(String[] args) {
        System.out.println(Solution.checkInclusion("ab", "eidbaooo"));
    }

    class Solution {
        public static boolean checkInclusion(String s1, String s2) {
            int s1Len = s1.length(), s2Len = s2.length();
            if (s1Len > s2Len) {
                return false;
            }
            int[] s1Cnt = new int[26];
            int[] s2Cnt = new int[26];

            for (int i = 0; i < s1Len; i++) {
                s1Cnt[s1.charAt(i) - 'a']++;
                s2Cnt[s2.charAt(i) - 'a']++;
            }
            if (Arrays.equals(s1Cnt, s2Cnt)) {
                return true;
            }
            int l = 0, r = s1Len - 1;
            while (r < s2Len) {
                s2Cnt[s2.charAt(l) - 'a']--;
                s2Cnt[s2.charAt(r) - 'a']++;
                l++;
                r++;
                if (Arrays.equals(s1Cnt, s2Cnt)) {
                    return true;
                }
            }
            return false;
        }
    }
}
